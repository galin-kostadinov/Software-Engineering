package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class SpeedMotorcycle extends MotorcycleImpl {
    private final static double CUBIC_CENTIMETERS = 125;
    private final static int MINIMUM_HORSEPOWER = 50;
    private final static int MAXIMUM_HORSEPOWER = 69;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER || horsePower > MAXIMUM_HORSEPOWER) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }

        super.setHorsePower(horsePower);
    }
}
