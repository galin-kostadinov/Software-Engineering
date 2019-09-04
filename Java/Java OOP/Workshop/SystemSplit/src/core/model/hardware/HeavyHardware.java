package core.model.hardware;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.HEAVY, maximumCapacity, maximumMemory);
    }

    @Override
    public int getMaximumCapacity() {
        return super.getMaximumCapacity() * 2;
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory -= baseMemory / 4;
        return baseMemory;
    }
}
