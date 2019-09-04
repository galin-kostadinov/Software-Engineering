package core.command;

import core.command.BaseCommand;
import core.model.software.ExpressSoftware;
import core.model.software.LightSoftware;
import core.model.software.Software;
import core.system.SystemSplit;

public class RegisterLightSoftwareCommand extends BaseCommand {
    private SystemSplit systemSplit;
    private String hardwareComponentName;
    private String name;
    private int capacity;
    private int memory;

    public RegisterLightSoftwareCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareComponentName = args[1].toString();
        this.name = args[2].toString();
        this.capacity = Integer.parseInt(args[3].toString());
        this.memory = Integer.parseInt(args[4].toString());
    }

    @Override
    public void execute() {
        Software software = new LightSoftware(this.name, this.capacity, this.memory);
        this.systemSplit.addSoftwareToHardware(this.hardwareComponentName, software);
    }

}
