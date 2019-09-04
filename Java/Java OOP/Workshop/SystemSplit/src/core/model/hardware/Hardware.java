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
