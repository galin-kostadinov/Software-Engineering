package core.command;

import core.system.SystemSplit;

public class AnalyzeCommand extends BaseCommand{
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

    }
}
