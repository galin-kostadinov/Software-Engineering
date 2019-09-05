package core.command;

import core.model.hardware.Hardware;
import core.system.DumpExtension;

public class DestroyCommand extends BaseCommand {
    private DumpExtension dumpExtension;
    private String name;

    public DestroyCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.dumpExtension = (DumpExtension) args[0];
        this.name = args[1].toString();
    }

    @Override
    public void execute() {
        Hardware hardware = dumpExtension.getHardwareComponentFromDumpHardwareCollection(this.name);

        if (hardware != null) {
            dumpExtension.removeHardwareComponentFromDumpHardwareCollection(hardware);
        }
    }
}
