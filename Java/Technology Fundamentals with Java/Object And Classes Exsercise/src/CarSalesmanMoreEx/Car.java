package CarSalesmanMoreEx;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format(
                "%s:%n"
                        + "%s:%n"
                        + "Power: %d%n"
                        + "Displacement: %s%n"
                        + "Efficiency: %s%n"
                        + "Weight: %s%n"
                        + "Color: %s",
                this.model,
                this.engine.getModel(),
                this.engine.getPower(),
                this.engine.getDisplacement(),
                this.engine.getEfficiency(),
                this.weight,
                this.color
        );
    }
}
