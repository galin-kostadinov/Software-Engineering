package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    public Car(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire1() {
        return tire1;
    }


    public Tire getTire2() {
        return tire2;
    }

    public Tire getTire3() {
        return tire3;
    }

    public Tire getTire4() {
        return tire4;
    }
}
