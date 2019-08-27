package vehicle;

public class Truck extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity, ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel);
        super.setFuelQuantity(super.getFuelQuantity() - fuel * 0.05);
    }
}
