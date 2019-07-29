package VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public Vehicle() {
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n"
                        + "%s: %s%n"
                        + "%s: %s%n"
                        + "%s: %d",
                "Type", this.getType().toUpperCase().charAt(0) + this.getType().substring(1),
                "Model", this.getModel(),
                "Color", this.getColor(),
                "Horsepower", this.getHorsepower());
    }
}
