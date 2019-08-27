package vehicle;

public class Bus extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity, ADDITIONAL_CONSUMPTION);
    }
}