package core.command;

import core.system.SystemSplit;

public class AnalyzeCommand extends BaseCommand {
    private SystemSplit systemSplit;

    public AnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();

        int hardwareComponentsCount = this.systemSplit.getHardwareComponentSize();
        int softwareComponentsCount = this.systemSplit.getSoftwareComponentCount();

        int totalMemoryInUsed = this.systemSplit.getTotalOperationalMemoryInUse();
        int totalCapacityTaken = this.systemSplit.getTotalCapacityTaken();

        int maximumMemory = this.systemSplit.getMaximumMemory() + totalMemoryInUsed;
        int maximumCapacity = this.systemSplit.getMaximumCapacity() + totalCapacityTaken;

        sb.append("System Analysis").append(System.lineSeparator());
        sb.append(String.format("Hardware Components: %d%n", hardwareComponentsCount));
        sb.append(String.format("Software Components: %d%n", softwareComponentsCount));
        sb.append(String.format("Total Operational Memory: %d / %d%n", totalMemoryInUsed, maximumMemory));
        sb.append(String.format("Total Capacity Taken: %d / %d", totalCapacityTaken, maximumCapacity));

        System.out.println(sb.toString());
    }
}
