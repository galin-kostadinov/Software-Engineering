package core.model.hardware;

public class PowerHardware extends Hardware {
    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.POWER, maximumCapacity, maximumMemory);
    }

    @Override
    public int getMaximumCapacity() {
        int baseCapacity = super.getMaximumCapacity();
        baseCapacity -= (baseCapacity * 3) / 4;
        return baseCapacity;
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory += (baseMemory * 3) / 4;
        return baseMemory;
    }
}
