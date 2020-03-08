package homework.gamestore.commands.view;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.GameTitleViewDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

import java.util.Set;

public class OwnedGames extends Command {
    public OwnedGames(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        if (this.getUserService().getLoggedUser().isEmpty()) {
            return "No current user.";
        }

        Set<GameTitleViewDto> titles = this.getUserService().getOwnedGamesTitle(this.getUserService().getLoggedUser());

        if (titles.isEmpty()){
            return "No games has bought from current user.";
        }

        StringBuilder sb = new StringBuilder();

        for (GameTitleViewDto gameTitleViewDto : titles) {
            sb.append(gameTitleViewDto.getTitle()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
