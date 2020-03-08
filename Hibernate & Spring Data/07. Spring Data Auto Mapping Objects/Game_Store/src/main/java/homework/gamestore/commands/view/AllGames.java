package homework.gamestore.commands.view;

import homework.gamestore.commands.Command;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class AllGames extends Command {
    public AllGames(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        StringBuilder sb = new StringBuilder();
        this.getGameService()
                .getTitleAndPrice()
                .forEach(g -> sb.append(String.format("%s %s", g.getTitle(), g.getPrice())).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
