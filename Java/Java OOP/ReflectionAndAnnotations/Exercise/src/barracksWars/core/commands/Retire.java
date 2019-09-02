package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String output;

        try {
            this.repository.removeUnit(unitType);
            output = unitType + " retired!";
        } catch (IllegalArgumentException ex) {
            output = ex.getMessage();
        }

        return output;
    }
}
