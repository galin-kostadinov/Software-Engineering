package homework.gamestore.commands.shop;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.GameTitleViewDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class RemoveItem extends Command {
    public RemoveItem(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        GameTitleViewDto gameTitleViewDto = new GameTitleViewDto(args[0]);
        return this.getUserService().removeGameFromUserCart(gameTitleViewDto);
    }
}
