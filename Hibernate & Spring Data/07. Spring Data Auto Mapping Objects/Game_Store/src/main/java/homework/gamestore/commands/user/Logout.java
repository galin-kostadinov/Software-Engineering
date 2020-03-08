package homework.gamestore.commands.user;

import homework.gamestore.commands.Command;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class Logout extends Command {
    public Logout(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        String messageLogout = this.getUserService().logoutUser();

        if (messageLogout.contains("successfully logged out")) {
            this.getGameService().logOutUser();
        }

        return messageLogout;
    }
}
