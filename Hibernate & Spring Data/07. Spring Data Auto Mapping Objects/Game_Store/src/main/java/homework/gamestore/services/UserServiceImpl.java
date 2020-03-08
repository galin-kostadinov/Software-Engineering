package homework.gamestore.services;

import homework.gamestore.domain.dtos.GameTitleViewDto;
import homework.gamestore.domain.dtos.UserLoginDto;
import homework.gamestore.domain.dtos.UserRegisterDto;
import homework.gamestore.domain.entities.Game;
import homework.gamestore.domain.entities.Role;
import homework.gamestore.domain.entities.User;
import homework.gamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final GameService gameService;
    private ModelMapper modelMapper;
    private String loggedInUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameService gameService) {
        this.userRepository = userRepository;
        this.gameService = gameService;
        this.modelMapper = new ModelMapper();
        this.loggedInUser = "";
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        StringBuilder stringBuilder = new StringBuilder();

        User user = this.modelMapper.map(userRegisterDto, User.class);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        User inDb = this.userRepository.getUserByEmail(user.getEmail()).orElse(null);

        if (inDb != null) {
            return "User with entered email already exist.";
        }

        if (violations.size() > 0) {
            for (ConstraintViolation<User> violation : violations) {
                stringBuilder.append(violation.getMessage()).append(System.lineSeparator());
            }
        } else {
            if (this.userRepository.count() == 0) {
                user.setRole(Role.ADMIN);
            } else {
                user.setRole(Role.USER);
            }

            stringBuilder.append(String.format("%s was registered", user.getFullName()));

            this.userRepository.saveAndFlush(user);
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        String result;

        if (!this.loggedInUser.isEmpty()) {
            return "User is already logged in";
        }

        User user = this.userRepository.getUserByEmail(userLoginDto.getEmail()).orElse(null);

        if (user == null) {
            return "Incorrect email.";
        } else {
            if (!user.getPassword().equals(userLoginDto.getPassword())) {
                return "Incorrect password!";
            }

            result = String.format("Successfully logged in %s", user.getFullName());
            this.loggedInUser = user.getEmail();
        }

        return result;
    }

    @Override
    public String logoutUser() {
        if (this.loggedInUser.isEmpty()) {
            return "Cannot log out. No user was logged in.";
        }

        User user = this.userRepository.getUserByEmail(this.loggedInUser).orElse(null);

        String result = String.format("User %s successfully logged out", user.getFullName());
        this.loggedInUser = "";

        return result;
    }

    @Override
    public Set<GameTitleViewDto> getOwnedGamesTitle(String email) {
        if (email != null) {
            return this.userRepository
                    .getUserByEmail(email)
                    .map(user -> user.getGames()
                            .stream()
                            .map(game -> modelMapper.map(game, GameTitleViewDto.class))
                            .collect(Collectors.toSet())).orElse(new HashSet<>());
        }

        return new HashSet<>();
    }

    @Override
    public String getLoggedUser() {
        return this.loggedInUser;
    }

    @Override
    public String addGameToUserCart(GameTitleViewDto gameTitleViewDto) {
        if (this.getLoggedUser().isEmpty()) {
            return "There is no logged user.";
        }

        Game game = this.gameService.getGameByTitle(gameTitleViewDto.getTitle());

        if (game == null) {
            return "There is no game with entered title.";
        }

        User user = this.userRepository.getUserByEmail(this.getLoggedUser()).orElse(null);

        if (user.getGames() != null && user.getGames().contains(game)) {
            return "User already have that game.";
        }

        if (user.getShoppingCard() != null && user.getShoppingCard().contains(game)) {
            return "User already have that game in shopping cart.";
        }

        user.getShoppingCard().add(game);

        this.userRepository.saveAndFlush(user);

        return String.format("%s added to cart.", gameTitleViewDto.getTitle());
    }

    @Override
    public String removeGameFromUserCart(GameTitleViewDto gameTitleViewDto) {
        if (this.getLoggedUser().isEmpty()) {
            return "There is no logged user.";
        }

        Game game = this.gameService.getGameByTitle(gameTitleViewDto.getTitle());

        if (game == null) {
            return "There is no game with entered title.";
        }

        User user = this.userRepository.getUserByEmail(this.getLoggedUser()).orElse(null);

        if (user.getShoppingCard() == null || !user.getShoppingCard().contains(game)) {
            return String.format("There is no game with title %s in cart", gameTitleViewDto.getTitle());
        }

        user.getShoppingCard().remove(game);

        this.userRepository.saveAndFlush(user);

        return String.format("%s removed from cart", gameTitleViewDto.getTitle());
    }

    @Override
    public String buyItemsFromShoppingCart() {
        if (this.getLoggedUser().isEmpty()) {
            return "There is no logged user.";
        }

        User user = this.userRepository.getUserByEmail(this.getLoggedUser()).orElse(null);

        if (user.getShoppingCard() == null || user.getShoppingCard().isEmpty()) {
            return "There are no games in shopping cart";
        }

        user.getGames().addAll(user.getShoppingCard());

        StringBuilder sb = new StringBuilder();
        sb.append("Successfully bought games:").append(System.lineSeparator());

        for (Game game : user.getShoppingCard()) {
            sb.append(String.format(" -%s", game.getTitle())).append(System.lineSeparator());
        }

        user.getShoppingCard().clear();

        this.userRepository.saveAndFlush(user);

        return sb.toString().trim();
    }
}
