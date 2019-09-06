package models;

import exceptions.ArgumentException;
import helpers.Validator;


public class Yacht extends Boat {
    private Engine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, Engine boatEngine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.setCargoWeight(cargoWeight);
    }

    public void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (Validator.validateParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Cargo Weight"));
        }
    }

    @Override
    public double calcSpeed(Race race) {
        return 0;
    }
}
