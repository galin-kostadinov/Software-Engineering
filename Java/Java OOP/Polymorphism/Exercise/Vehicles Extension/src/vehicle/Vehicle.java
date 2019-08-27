package vehicle;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double additionalConsumption;
    private double tankCapacity;
    private boolean isSwitchOnAirConditioning;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity, double additionalConsumption) {
        this.setTankCapacity(tankCapacity);
        this.fuelQuantity = fuelQuantity;
        this.isSwitchOnAirConditioning();
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption(fuelConsumptionPerKm);
    }

    private void isSwitchOnAirConditioning() {
        this.isSwitchOnAirConditioning = true;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private void setFuelConsumption(double fuelConsumptionPerKm) {
        if (isSwitchOnAirConditioning) {
            this.fuelConsumptionPerKm = fuelConsumptionPerKm + this.additionalConsumption;
        } else {
            this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        }
    }

    public void switchOnAdditionalConsumption() {
        if (!isSwitchOnAirConditioning) {
            this.fuelConsumptionPerKm += this.additionalConsumption;
            isSwitchOnAirConditioning = true;
        }
    }

    public void switchOffAdditionalConsumption() {
        if (isSwitchOnAirConditioning) {
            this.fuelConsumptionPerKm -= this.additionalConsumption;
            isSwitchOnAirConditioning = false;
        }
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void refuel(double fuel) {
        double result = this.fuelQuantity + fuel;

        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (result > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuel;
        }
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

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }

}
