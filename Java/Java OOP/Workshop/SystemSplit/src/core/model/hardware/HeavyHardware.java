package core.model.hardware;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.HEAVY, maximumCapacity, maximumMemory);
    }

    @Override
    public int getMaximumCapacity() {
        return super.getMaximumCapacity() * 2 - super.getUsedCapacity();
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory -= baseMemory / 4;
        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}