package homework.gamestore.services;

import homework.gamestore.domain.dtos.GameAddDto;
import homework.gamestore.domain.dtos.GameEditDto;
import homework.gamestore.domain.dtos.GameViewDetailsDto;
import homework.gamestore.domain.dtos.GameViewTitleAndPriceDto;
import homework.gamestore.domain.entities.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    String addGame(GameAddDto gameAddDto);

    void setLoggedInUser(String email);

    void logOutUser();

    String editGame(GameEditDto gameEditDto, Long id);

    String deleteGame(Long gameDeleteDto);

    GameEditDto getEditGameDtoById(final Long id);

    List<GameViewTitleAndPriceDto> getTitleAndPrice();

    GameViewDetailsDto getViewDetails(String title);

    Game getGameByTitle(String title);
}
