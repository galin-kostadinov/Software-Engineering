package models.battleFields;

import common.ConstantMessages;
import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException(ConstantMessages.DEAD_PLAYER);
        }

        increaseStatsIfBeginner(attackPlayer);
        increaseStatsIfBeginner(enemyPlayer);

        getBonusHealthFromDeck(attackPlayer);
        getBonusHealthFromDeck(enemyPlayer);

        int attackerDamage = getDamageFromDeck(attackPlayer);
        int enemyDamage = getDamageFromDeck(enemyPlayer);

        int turn = 0;
        while (!attackPlayer.isDead() && !enemyPlayer.isDead()) {
            if (turn % 2 == 0) {
                enemyPlayer.takeDamage(attackerDamage);
            } else {
                attackPlayer.takeDamage(enemyDamage);
            }

            turn++;
        }
    }

    private void increaseStatsIfBeginner(Player player) {
        if (player instanceof Beginner) {
            int health = player.getHealth() + 40;
            player.setHealth(health);

            player.getCardRepository()
                    .getCards()
                    .forEach(c -> c.setDamagePoints(c.getDamagePoints() + 30));

        }
    }

    private void getBonusHealthFromDeck(Player player) {
        int healthSum = player
                .getCardRepository()
                .getCards()
                .stream()
                .mapToInt(Card::getHealthPoints)
                .sum();

        player.setHealth(player.getHealth() + healthSum);
    }

    private int getDamageFromDeck(Player player) {
        return player
                .getCardRepository()
                .getCards()
                .stream()
                .mapToInt(Card::getDamagePoints)
                .sum();
    }
}
