package core.model.hardware;

import core.model.software.Software;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware {
    private String name;
    private Type type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwares;

    public Hardware(String name, Type type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwares = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    private void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    public void addSoftware(Software software) {
        if (software.getMemoryConsumption() <= this.getMaximumMemory() &&
                software.getCapacityConsumption() <= this.getMaximumCapacity()) {
            this.softwares.add(software);
            this.setUsedResources(software);
        }
    }

    protected abstract void setUsedResources(Software software);

    protected enum Type {
        POWER,
        HEAVY
    }
}
