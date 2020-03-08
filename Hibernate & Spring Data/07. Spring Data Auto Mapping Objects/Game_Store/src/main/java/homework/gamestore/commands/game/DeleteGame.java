package homework.gamestore.commands.game;

import homework.gamestore.commands.Command;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class DeleteGame extends Command {
    public DeleteGame(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        Long id = Long.parseLong(args[0]);
        return this.getGameService().deleteGame(id);
    }
}
