package models;

import exceptions.ArgumentException;
import helpers.BoatValidator;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    public void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if (BoatValidator.validateSailEfficiency(sailEfficiency)) {
            this.sailEfficiency = sailEfficiency;
        } else {
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
    }
}
