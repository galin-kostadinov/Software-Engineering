package homework.gamestore.commands.game;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.GameEditDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditGame extends Command {
    private static final int COMMAND_INDEX = 0;
    private static final int VALUE_INDEX = 1;

    public EditGame(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        Long id = Long.parseLong(args[0]);

        GameEditDto gameEditDto = getGameService().getEditGameDtoById(id);

        if (gameEditDto == null) {
            return String.format("Is not found game with ID %s", id);
        }

        for (int i = 1; i < args.length; i++) {
            String[] tokens = args[i].split("=");

            switch (tokens[COMMAND_INDEX]) {
                case "title":
                    gameEditDto.setTitle(tokens[VALUE_INDEX]);
                    break;
                case "price":
                    gameEditDto.setPrice(new BigDecimal(tokens[VALUE_INDEX]));
                    break;
                case "size":
                    gameEditDto.setSize(Double.parseDouble(tokens[VALUE_INDEX]));
                    break;
                case "thumbnail":
                    gameEditDto.setImageThumbnail(tokens[VALUE_INDEX]);
                    break;
                case "trailer":
                    gameEditDto.setTrailer(tokens[VALUE_INDEX]);
                    break;
                case "description":
                    gameEditDto.setDescription(tokens[VALUE_INDEX]);
                    break;
                case "date":
                    gameEditDto.setReleaseDate(LocalDate.parse(tokens[VALUE_INDEX], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
                default:
                    break;
            }
        }

        return this.getGameService().editGame(gameEditDto, id);
    }
}
