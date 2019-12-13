package models.players;

import common.ConstantMessages;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import java.util.List;

public abstract class BasePlayer implements Player {
    private CardRepository cardRepository;
    private String username;
    private int health;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
        this.setDead(false);
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(ConstantMessages.INCORRECT_USERNAME);
        }

        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException(ConstantMessages.INCORRECT_HEALTH);
        }

        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException(ConstantMessages.INCORRECT_DAMAGE);
        }

        this.health -= damagePoints;

        if (this.getHealth() <= 0) {
            this.setHealth(0);
            this.setDead(true);
        }
    }

    @Override
    public String toString() {
        String player = String.format(ConstantMessages.PLAYER_REPORT_INFO
                , this.getUsername()
                , this.getHealth()
                , this.cardRepository.getCount());

        List<Card> cards = cardRepository.getCards();

        StringBuilder stringBuilder = new StringBuilder();

        for (Card card : cards) {
            stringBuilder.append(card.toString()).append(System.lineSeparator());
        }
        stringBuilder.append(ConstantMessages.DEFAULT_REPORT_SEPARATOR);

        return player + System.lineSeparator() + stringBuilder.toString();
    }
}
