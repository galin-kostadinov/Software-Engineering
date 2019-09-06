package models;

import exceptions.ArgumentException;
import helpers.Validator;
import models.interfaces.Speed;

public abstract class Boat implements Comparable<Boat>, Speed {
    private static final int MIN_MODEL_LENGTH = 5;

    private String model;
    private int weight;

    protected Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setWeight(int weight) throws ArgumentException {
        if (Validator.validateParam(weight)) {
            this.weight = weight;
        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Weight"));
        }
    }

    private void setModel(String model) throws ArgumentException {
        if (Validator.validateBoatModel(model)) {
            this.model = model;
        } else {
            throw new ArgumentException("Model's name must be at least"
                    + MIN_MODEL_LENGTH
                    + " symbols long.");
        }
    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass().getSuperclass() != obj.getClass().getSuperclass()) return false;

        Boat boat = (Boat) obj;

        return super.equals(boat.model);
    }

    protected int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Boat o) {
        return this.model.compareTo(o.model);
    }
}
