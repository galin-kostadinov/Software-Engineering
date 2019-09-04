package core.model.hardware;

import core.model.software.Software;

public class HeavyHardware extends Hardware {
    private int usedCapacity;
    private int usedMemory;

    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.HEAVY, maximumCapacity, maximumMemory);
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    @Override
    public int getMaximumCapacity() {
        return super.getMaximumCapacity() * 2 - this.usedCapacity;
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory -= baseMemory / 4;
        return baseMemory - this.usedMemory;
    }

    @Override
    protected void setUsedResources(Software software) {
        this.usedCapacity += software.getCapacityConsumption();
        this.usedMemory += software.getMemoryConsumption();
    }
}
