package core.model.hardware;

import core.model.software.Software;

public class PowerHardware extends Hardware {
    private int usedCapacity;
    private int usedMemory;

    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.POWER, maximumCapacity, maximumMemory);
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    @Override
    public int getMaximumCapacity() {
        int baseCapacity = super.getMaximumCapacity();
        baseCapacity -= (baseCapacity * 3) / 4;
        return baseCapacity - this.usedCapacity;
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory += (baseMemory * 3) / 4;
        return baseMemory - this.usedMemory;
    }

    @Override
    protected void setUsedResources(Software software) {
        this.usedCapacity += software.getCapacityConsumption();
        this.usedMemory += software.getMemoryConsumption();
    }
}
