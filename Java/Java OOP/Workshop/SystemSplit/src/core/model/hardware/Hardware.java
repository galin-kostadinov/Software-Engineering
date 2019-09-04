package core.model.hardware;

import core.model.software.Software;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public abstract class Hardware {
    private String name;
    private Type type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwares;
    private int usedCapacity;
    private int usedMemory;

    public Hardware(String name, Type type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwares = new ArrayList<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type.name();
    }

    public int getSoftwareCount() {
        return this.softwares.size();
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
            this.setUsedResources(software, (a, b) -> a += b);
        }
    }

    public final int getUsedCapacity() {
        return usedCapacity;
    }

    public final int getUsedMemory() {
        return usedMemory;
    }

    private void setUsedResources(Software software, BinaryOperator<Integer> operator) {
        this.usedCapacity = operator.apply(this.usedCapacity, software.getCapacityConsumption());
        this.usedMemory = operator.apply(this.usedMemory, software.getMemoryConsumption());
    }

    public void removeSoftware(String softwareName) {
        Software software = this.softwares
                .stream()
                .filter(s -> s.getName().equals(softwareName))
                .findFirst()
                .orElse(null);
        if (software != null) {
            this.softwares.remove(software);
            this.setUsedResources(software, (a, b) -> a -= b);
        }
    }

    @Override
    public String toString() {
        long expressSoftwareCount = this.softwares
                .stream()
                .filter(s -> s.getClass().getSimpleName().equals("ExpressSoftware"))
                .count();


        return String.format("Hardware Component - %s%n" +
                        "Express Software Components - %d%n" +
                        "Light Software Components - %d%n" +
                        "Memory Usage: %d / %d%n" +
                        "Capacity Usage: %d / %d%n" +
                        "Type: %s%n" +
                        "Software Components: %s",
                this.getName(),
                expressSoftwareCount,
                this.softwares.size() - expressSoftwareCount,
                this.usedMemory,
                this.getMaximumMemory() + this.usedMemory,
                this.usedCapacity,
                this.getMaximumCapacity() + this.usedCapacity,
                this.type.compareTo(Type.HEAVY) == 0 ? "Heavy" : "Power",
                this.softwares.size() == 0 ? "None" :
                        this.softwares.stream().map(Software::getName)
                                .collect(Collectors.joining(", ")));
    }

    protected enum Type {
        POWER,
        HEAVY
    }
}
