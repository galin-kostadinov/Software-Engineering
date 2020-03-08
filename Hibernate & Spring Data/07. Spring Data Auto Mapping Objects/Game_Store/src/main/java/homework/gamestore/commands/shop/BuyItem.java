package homework.gamestore.commands.shop;

import homework.gamestore.commands.Command;
import homework.gamestore.domain.dtos.GameTitleViewDto;
import homework.gamestore.services.GameService;
import homework.gamestore.services.UserService;

public class BuyItem extends Command {
    public BuyItem(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        return this.getUserService().buyItemsFromShoppingCart();
    }
}
