package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double OXYGEN_DECREASE_STEP = 5;
    private static final double INITIAL_UNITS_OF_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        double result = super.getOxygen() - OXYGEN_DECREASE_STEP;

        super.setOxygen(result);
    }
}
