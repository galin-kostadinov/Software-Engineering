package vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private boolean airConditionIsOn;
    private double additionalConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double additionalConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setAirConditionIsOn();
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption(fuelConsumptionPerKm);
    }

    private void setFuelConsumption(double fuelConsumptionPerKm) {
        if (airConditionIsOn) {
            this.fuelConsumptionPerKm = fuelConsumptionPerKm + this.additionalConsumption;
        } else {
            this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        }
    }

    private void setAirConditionIsOn() {
        this.airConditionIsOn = true;
    }

    public String drive(double distance) {
        String output;
        double fuelNeeded = distance * this.fuelConsumptionPerKm;

        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            output = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    decimalFormat.format(distance));
        } else {
            output = String.format("%s needs refueling",
                    this.getClass().getSimpleName());
        }
        return output;
    }

    public void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
