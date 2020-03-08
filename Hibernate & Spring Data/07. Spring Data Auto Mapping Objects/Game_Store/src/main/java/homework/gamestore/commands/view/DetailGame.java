package homework.gamestore.commands.view;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.GameViewDetailsDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class DetailGame extends Command {
    public DetailGame(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        GameViewDetailsDto gameViewDetailsDto = this.getGameService().getViewDetails(args[0]);

        if (gameViewDetailsDto == null) {
            return String.format("Game with title %s does't exist.", args[0]);
        }

     return   gameViewDetailsDto.toString();
    }
}
