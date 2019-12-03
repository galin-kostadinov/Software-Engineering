package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PilotImpl implements Pilot {
    private static final String NAME_MISSING_ERROR = "Pilot name cannot be null or empty string.";

    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_MISSING_ERROR);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }

        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return Collections.unmodifiableList(this.machines);
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.getName()).append(" - ")
                .append(this.getMachines().size())
                .append(" machines")
                .append(System.lineSeparator());
        for (Machine machine : machines) {
            stringBuilder.append(machine.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
