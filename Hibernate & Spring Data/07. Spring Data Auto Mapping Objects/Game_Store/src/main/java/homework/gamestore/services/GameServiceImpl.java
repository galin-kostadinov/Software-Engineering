package homework.gamestore.services;

import homework.gamestore.domain.dtos.GameAddDto;
import homework.gamestore.domain.dtos.GameEditDto;
import homework.gamestore.domain.dtos.GameViewDetailsDto;
import homework.gamestore.domain.dtos.GameViewTitleAndPriceDto;
import homework.gamestore.domain.entities.Game;
import homework.gamestore.domain.entities.Role;
import homework.gamestore.domain.entities.User;
import homework.gamestore.repositories.GameRepository;
import homework.gamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private String loggedInUser;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedInUser = "";
    }

    @Override
    public String addGame(GameAddDto gameAddDto) {
        String message = checkIsAdmin();
        if (!message.isEmpty()) {
            return message;
        }

        if (this.gameRepository.findByTitle(gameAddDto.getTitle()) != null) {
           return String.format("%s already exist in catalog.", gameAddDto.getTitle());
        }

        StringBuilder sb = new StringBuilder();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Game game = this.modelMapper.map(gameAddDto, Game.class);
        Set<ConstraintViolation<Game>> violations = validator.validate(game);

        if (violations.size() > 0) {
            for (ConstraintViolation<Game> violation : violations) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }

            return sb.toString().trim();
        }

        this.gameRepository.saveAndFlush(game);
        return String.format("Added %s", game.getTitle());
    }

    @Override
    public void setLoggedInUser(String email) {
        this.loggedInUser = email;
    }

    @Override
    public void logOutUser() {
        this.loggedInUser = "";
    }

    @Override
    public String editGame(GameEditDto gameEditDto, Long id) {
        String message = checkIsAdmin();
        if (!message.isEmpty()) {
            return message;
        }

        Game game = this.gameRepository.findById(id).orElse(null);

        if (game == null) {
            return String.format("Is not found game with ID %d", id);
        }

        game = modelMapper.map(gameEditDto, Game.class);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Game>> violations = validator.validate(game);

        StringBuilder stringBuilder = new StringBuilder();

        if (violations.size() > 0) {
            for (ConstraintViolation<Game> violation : violations) {
                stringBuilder.append(violation.getMessage()).append(System.lineSeparator());
            }

            return stringBuilder.toString().trim();
        }

        game.setId(id);
        this.gameRepository.saveAndFlush(game);

        return String.format("Edited %s", game.getTitle());
    }

    @Override
    public String deleteGame(Long id) {
        String message = checkIsAdmin();

        if (!message.isEmpty()) {
            return message;
        }

        Game game = this.gameRepository.findById(id).orElse(null);

        if (game == null) {
            return String.format("Is not found game with ID %d", id);
        }

        Set<User> users = game.getUsers();

        for (User user : users) {
            user.getGames().remove(game);
            this.userRepository.saveAndFlush(user);
        }

        this.gameRepository.deleteById(id);

        return String.format("Deleted %s", game.getTitle());
    }

    @Override
    public GameEditDto getEditGameDtoById(final Long id) {
        Game game = this.gameRepository.findById(id).orElse(null);

        if (game == null) {
            return null;
        }

        return modelMapper.map(game, GameEditDto.class);
    }

    @Override
    public List<GameViewTitleAndPriceDto> getTitleAndPrice() {
        List<Game> games = this.gameRepository.findAll();

        if (games.isEmpty()) {
            return new ArrayList<>();
        }

        List<GameViewTitleAndPriceDto> gamesDto = new ArrayList<>();

        for (Game game : games) {
            gamesDto.add(modelMapper.map(game, GameViewTitleAndPriceDto.class));
        }

        return gamesDto;
    }

    @Override
    public GameViewDetailsDto getViewDetails(String title) {
        Game game = this.gameRepository.findByTitle(title);

        if (game == null) {
            return null;
        }

        return modelMapper.map(game, GameViewDetailsDto.class);
    }

    @Override
    public Game getGameByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }

    private String checkIsAdmin() {
        User user = this.userRepository.getUserByEmail(loggedInUser).orElse(null);

        if (user == null) {
            return "There is no logged-in user";
        }

        if (!user.getRole().equals(Role.ADMIN)) {
            return String.format("%s is not admin!", user.getFullName());
        }

        return "";
    }
}
