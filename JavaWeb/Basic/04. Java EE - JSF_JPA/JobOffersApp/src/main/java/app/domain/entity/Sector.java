package app.domain.entity;

public enum Sector {
    MEDICINE("Medicine"),
    CAR("Car"),
    FOOD("Food"),
    DOMESTIC("Domestic"),
    SECURITY("Security");

    public final String label;

    private Sector(String label) {
        this.label = label;
    }
}
