package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.BaseMachine;
import entities.FighterImpl;
import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private Map<String, Pilot> pilots;
    private MachineFactory machineFactory;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {

        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }

    @Override
    public String hirePilot(String name) {
        String message;

        if (this.pilots.containsKey(name)) {
            message = String.format(OutputMessages.pilotExists, name);
        } else {
            this.pilots.put(name, pilotFactory.createPilot(name));

            message = String.format(OutputMessages.pilotHired, name);
        }

        return message;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        String message;

        if (machines.containsKey(name)) {
            message = String.format(OutputMessages.machineExists, name);
        } else {
            machines.put(name, machineFactory.createTank(name, attackPoints, defensePoints));

            message = String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
        }

        return message;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        String message;

        if (machines.containsKey(name)) {
            message = String.format(OutputMessages.machineExists, name);
        } else {
            machines.put(name, machineFactory.createFighter(name, attackPoints, defensePoints));

            message = String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
        }

        return message;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);

        if (pilot == null) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }

        if (machine == null) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }


        if (machine.getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }
        
        pilot.addMachine(machine);
        machine.setPilot(pilot);

        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attackingMachine = this.machines.get(attackingMachineName);
        Machine defendingMachine = this.machines.get(defendingMachineName);

        String message;

        if (attackingMachine == null) {
            message = String.format(OutputMessages.machineNotFound, attackingMachineName);
        } else if (defendingMachine == null) {
            message = String.format(OutputMessages.machineNotFound, defendingMachineName);
        } else {
            attackingMachine.attack(defendingMachineName);

            if (attackingMachine.getAttackPoints() > defendingMachine.getDefensePoints()) {
                defendingMachine.setHealthPoints(defendingMachine.getHealthPoints()
                        - (attackingMachine.getAttackPoints()
                        - defendingMachine.getDefensePoints()));

                if (defendingMachine.getHealthPoints() < 0) {
                    defendingMachine.setHealthPoints(0);
                }
            }

            message = String.format(OutputMessages.attackSuccessful,
                    defendingMachineName,
                    attackingMachineName,
                    defendingMachine.getHealthPoints());
        }

        return message;
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = this.pilots.get(pilotName);

        if (pilot == null) {
            return String.format(OutputMessages.pilotNotFound, pilotName);
        }

        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        try {
            Fighter fighter = (Fighter) this.machines.get(fighterName);
            fighter.toggleAggressiveMode();
            return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
        } catch (ClassCastException e) {
            return String.format(OutputMessages.notSupportedOperation, fighterName);
        }
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        try {
            Tank tank = (Tank) this.machines.get(tankName);
            tank.toggleDefenseMode();
            return String.format(OutputMessages.tankOperationSuccessful, tankName);
        } catch (ClassCastException e) {
            return String.format(OutputMessages.notSupportedOperation, tankName);
        }

    }
}
