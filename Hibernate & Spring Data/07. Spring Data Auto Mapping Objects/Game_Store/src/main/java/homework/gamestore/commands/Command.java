package homework.gamestore.commands;

import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public abstract class Command implements  Executable {
    private final UserService userService;
    private final GameService gameService;

    public Command(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    protected UserService getUserService() {
        return userService;
    }

    protected GameService getGameService() {
        return gameService;
    }
}
