package homework.gamestore.commands.game;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.GameAddDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddGame extends Command {
    private static final int TITLE_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int SIZE_INDEX = 2;
    private static final int TRAILER_INDEX = 3;
    private static final int THUMBNAIL_INDEX = 4;
    private static final int DESCRIPTION_INDEX = 5;
    private static final int RELEASE_DATE_INDEX = 6;

    public AddGame(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        GameAddDto gameAddDto =
                new GameAddDto(args[TITLE_INDEX],
                        args[TRAILER_INDEX],
                        args[THUMBNAIL_INDEX],
                        Double.parseDouble(args[SIZE_INDEX]),
                        new BigDecimal(args[PRICE_INDEX]),
                        args[DESCRIPTION_INDEX],
                        LocalDate.parse(args[RELEASE_DATE_INDEX], DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return this.getGameService().addGame(gameAddDto);
    }
}
