package models;

import exceptions.ArgumentException;

public class PowerBoat extends Boat {
    private Engine boatEngine;
    private Engine secondEngine;

    public PowerBoat(String model, int weight, Engine boatEngine, Engine secondEngine) throws ArgumentException {
        super(model, weight);
        this.boatEngine = boatEngine;
        this.secondEngine = secondEngine;
    }


    @Override
    public double calcSpeed(Race race) {
        return (this.boatEngine.getOutput() + this.secondEngine.getOutput())
                - this.getWeight()
                + race.getCurrentSpeed() / 5;

    }
}
