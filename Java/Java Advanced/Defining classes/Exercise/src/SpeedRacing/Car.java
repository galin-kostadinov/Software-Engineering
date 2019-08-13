package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        double maxDistance = this.fuelAmount / this.fuelCostFor1km;

        if (maxDistance >= distanceTraveled) {
            this.distanceTraveled += distanceTraveled;
            setFuelAmount(distanceTraveled);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void setFuelAmount(double distanceTraveled) {
        this.fuelAmount -= distanceTraveled * this.fuelCostFor1km;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }
}
