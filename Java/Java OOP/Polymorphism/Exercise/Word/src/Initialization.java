public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        ExtendedCommandImpl extendedCommands = new ExtendedCommandImpl(text);
        extendedCommands.init();
        return extendedCommands;
    }
}
