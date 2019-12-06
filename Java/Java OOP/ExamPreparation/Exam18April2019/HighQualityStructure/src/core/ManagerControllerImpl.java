package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import java.util.List;

public class ManagerControllerImpl implements ManagerController {
    private CardRepository cardRepository;
    private PlayerRepository playerRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.cardRepository = new CardRepositoryImpl();
        this.playerRepository = new PlayerRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player;
        CardRepository cartDeck = new CardRepositoryImpl();
        switch (type) {
            case "Advanced":
                player = new Advanced(cartDeck, username);
                break;
            case "Beginner":
                player = new Beginner(cartDeck, username);
                break;
            default:
                player = null;
                break;
        }

//        try {
            playerRepository.add(player);
//        } catch (IllegalArgumentException e) {
//            return e.getMessage();
//        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card;

        switch (type) {
            case "Magic":
                card = new MagicCard(name);
                break;
            case "Trap":
                card = new TrapCard(name);
                break;
            default:
                card = null;
                break;
        }

        //try {
            cardRepository.add(card);
//        } catch (IllegalArgumentException e) {
//            return e.getMessage();
//        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = playerRepository.find(username);
        Card card = cardRepository.find(cardName);

     //   try {
            player.getCardRepository().add(card);
//        } catch (IllegalArgumentException e) {
//            return e.getMessage();
//        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = playerRepository.find(attackUser);
        Player enemy = playerRepository.find(enemyUser);

        //try {
            battlefield.fight(attacker, enemy);
//        } catch (IllegalArgumentException e) {
//            return e.getMessage();
//        }

        return String.format(ConstantMessages.FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        List<Player> players = playerRepository.getPlayers();

        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(player.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
