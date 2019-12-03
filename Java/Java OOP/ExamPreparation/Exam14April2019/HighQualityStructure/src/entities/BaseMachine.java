package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private static final String NAME_MISSING_ERROR = "Machine name cannot be null or empty.";
    private static final String PILOT_MISSING_ERROR = "Pilot cannot be null.";

    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defensePoints);
        this.setHealthPoints(healthPoints);
        this.targets = new ArrayList<>();
        this.pilot = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_MISSING_ERROR);
        }

        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if (pilot == null) {
            throw new NullPointerException(PILOT_MISSING_ERROR);
        }

        this.pilot = pilot;
    }

    protected void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    protected void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    @Override
    public void attack(String target) {
        if (target == null || target.trim().isEmpty()) {
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }

        this.targets.add(target);
    }

    @Override
    public String toString() {
        String targets;

        if (this.getTargets().size() == 0) {
            targets = "None";
        }else {
            targets = this.getTargets().toString().replaceAll("[\\[\\]]", "");
        }

        return String.format("- %s%n" +
                        " *Type: %s%n" +
                        " *Health: %.2f%n" +
                        " *Attack: %.2f%n" +
                        " *Defense: %.2f%n" +
                        " *Targets: %s%n",
                this.getName(),
                this.getClass().getInterfaces()[0].getSimpleName(),
                this.getHealthPoints(),
                this.getAttackPoints(),
                this.getDefensePoints(),
                targets);
    }
}
