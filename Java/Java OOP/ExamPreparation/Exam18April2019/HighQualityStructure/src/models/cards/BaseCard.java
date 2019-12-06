package models.cards;

import common.ConstantMessages;
import models.cards.interfaces.Card;

public abstract class BaseCard implements Card {
    private String name;
    private int damagePoints;
    private int healthPoints;

    protected BaseCard(String name, int damagePoints, int healthPoints) {
        this.setName(name);
        this.setDamagePoints(damagePoints);
        this.setHealthPoints(healthPoints);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ConstantMessages.INCORRECT_CARD_NAME);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException(ConstantMessages.INCORRECT_DAMAGE_POINTS);
        }

        this.damagePoints = damagePoints;
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException(ConstantMessages.INCORRECT_HEALTH_POINTS);
        }

        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return String.format(ConstantMessages.CARD_REPORT_INFO
                , this.getName()
                , this.getDamagePoints());
    }
}
