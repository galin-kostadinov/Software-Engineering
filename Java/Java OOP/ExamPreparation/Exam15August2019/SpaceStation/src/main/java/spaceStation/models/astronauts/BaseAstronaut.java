package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private static final double OXYGEN_DECREASE_STEP = 10;
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }

        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        double result = this.oxygen - OXYGEN_DECREASE_STEP;

        this.setOxygen(result);
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s", this.getName())).append(System.lineSeparator());
        sb.append(String.format("Oxygen: %.0f", this.getOxygen())).append(System.lineSeparator());

        if (this.bag.getItems().size() == 0) {
            sb.append("Bag items: none").append(System.lineSeparator());
        } else {
            sb.append("Bag items: ").append(this.bag.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
