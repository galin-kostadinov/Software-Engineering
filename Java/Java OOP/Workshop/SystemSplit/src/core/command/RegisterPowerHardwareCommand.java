package core.command;

import core.model.hardware.Hardware;
import core.model.hardware.PowerHardware;
import core.system.SystemSplit;

public class RegisterPowerHardwareCommand extends BaseCommand {
    private SystemSplit systemSplit;
    private String name;
    private int capacity;
    private int memory;

    public RegisterPowerHardwareCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.name = args[1].toString();
        this.capacity = Integer.parseInt(args[2].toString());
        this.memory = Integer.parseInt(args[3].toString());
    }

    @Override
    public void execute() {
        Hardware hardware = new PowerHardware(this.name, this.capacity, this.memory);
        systemSplit.addHardwareComponent(hardware);
    }
}
