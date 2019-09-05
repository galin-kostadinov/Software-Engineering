package core.command;

import core.system.DumpExtension;

public class DumpAnalyzeCommand extends BaseCommand {
    private DumpExtension dumpExtension;

    public DumpAnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.dumpExtension = (DumpExtension) args[0];
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();

        long countOfPowerHardwareComponents = this.dumpExtension.getCountOfPowerHardwareComponents();
        long countOfHeavyHardwareComponents = this.dumpExtension.getCountOfHeavyHardwareComponents();

        long countOfExpressSoftwareComponents = this.dumpExtension.getCountOfExpressSoftwareComponents();
        long countOfLightSoftwareComponents = this.dumpExtension.getCountOfLightSoftwareComponents();

        int totalDumpedMemory = this.dumpExtension.getTotalDumpedMemory();
        int totalDumpedCapacity = this.dumpExtension.getTotalDumpedCapacity();


        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append(String.format("Power Hardware Components: %d%n", countOfPowerHardwareComponents));
        sb.append(String.format("Heavy Hardware Components: %d%n", countOfHeavyHardwareComponents));
        sb.append(String.format("Express Software Components: %d%n", countOfExpressSoftwareComponents));
        sb.append(String.format("Light Software Components: %d%n", countOfLightSoftwareComponents));
        sb.append(String.format("Total Dumped Memory: %d%n", totalDumpedMemory));
        sb.append(String.format("Total Dumped Capacity: %d", totalDumpedCapacity));

        System.out.println(sb.toString());
    }
}
