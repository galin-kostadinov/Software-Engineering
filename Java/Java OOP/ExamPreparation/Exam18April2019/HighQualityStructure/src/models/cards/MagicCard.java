package models.cards;

public class MagicCard extends BaseCard {
    private final static int DEFAULT_DAMAGE_POINTS = 5;
    private final static int DEFAULT_HEALTH_POINTS = 80;

    protected MagicCard(String name) {
        super(name, DEFAULT_DAMAGE_POINTS, DEFAULT_HEALTH_POINTS);
    }
}
