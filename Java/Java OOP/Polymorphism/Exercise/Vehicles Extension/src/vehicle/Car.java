package vehicle;

public class Car extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity, ADDITIONAL_CONSUMPTION);
    }
}