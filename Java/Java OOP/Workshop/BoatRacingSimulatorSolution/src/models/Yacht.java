package models;

import exceptions.ArgumentException;
import helpers.BoatValidator;


public class Yacht extends Boat {
    private Engine boatEngine;
    private int cargoWeight;

    public Yacht(String model, int weight, Engine boatEngine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.setCargoWeight(cargoWeight);
    }

    public void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (BoatValidator.validateParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        } else {
            throw new ArgumentException(this.generateErrorMessage("Cargo Weight"));
        }
    }
}
