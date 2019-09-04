package core.model.hardware;

public abstract class Hardware {
    private String name;
    private Type type;
    private int maximumCapacity;
    private int maximumMemory;

    public Hardware(String name, Type type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    protected enum Type {
        POWER,
        HEAVY
    }
}
