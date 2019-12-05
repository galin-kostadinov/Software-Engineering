package common;

public class ConstantMessages {

    public static final String SUCCESSFULLY_ADDED_PLAYER =
            "Successfully added player of type %s with username: %s";

    public static final String SUCCESSFULLY_ADDED_CARD =
            "Successfully added card of type %sCard with name: %s";

    public static final String SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS
            = "Successfully added card: %s to user: %s";

    public static final String FIGHT_INFO
            = "Attack user health %s - Enemy user health %s";

    public static final String PLAYER_REPORT_INFO
            = "Username: %s - Health: %d - Cards %d";

    public static final String CARD_REPORT_INFO
            = "Card: %s - Damage: %d";

    public static final String DEFAULT_REPORT_SEPARATOR
            = "###";

    public static final String INCORRECT_USERNAME =
            "Player's username cannot be null or an empty string. ";

    public static final String INCORRECT_HEALTH =
            "Player's health bonus cannot be less than zero. ";

    public static final String INCORRECT_DAMAGE =
            "Damage points cannot be less than zero.";

    public static final String INCORRECT_CARD_NAME =
            "Card's name cannot be null or an empty string.";

    public static final String INCORRECT_DAMAGE_POINTS =
            "Card's damage points cannot be less than zero.";

    public static final String INCORRECT_HEALTH_POINTS =
            "Card's HP cannot be less than zero.";

    public static final String DEAD_PLAYER =
            "Player is dead!";

    public static final String NULL_CARD =
            "Card cannot be null!";

    public static final String NULL_PLAYER =
            "Player cannot be null";

    public static final String EXISTING_PLAYER =
            "Player username already exists!";

    public static final String EXISTING_CARD =
            "Card name already exists!";
}
