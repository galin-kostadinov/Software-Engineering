package homework.gamestore.services;

import homework.gamestore.domain.dtos.GameTitleViewDto;
import homework.gamestore.domain.dtos.UserLoginDto;
import homework.gamestore.domain.dtos.UserRegisterDto;

import java.util.Set;

public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto userLoginDto);

    String logoutUser();

    Set<GameTitleViewDto> getOwnedGamesTitle(String email);

    String getLoggedUser();

    String addGameToUserCart(GameTitleViewDto gameTitleViewDto);

    String removeGameFromUserCart(GameTitleViewDto gameTitleViewDto);

    String buyItemsFromShoppingCart();
}
