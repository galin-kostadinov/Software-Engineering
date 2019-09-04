package core.command.factory;

import core.command.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
    private static final String BASE_COMMAND_PACKAGE = "core.command.";
    private static final String COMMAND_SUFFIX = "Command";

    public Command buildCommand(String name, Object... args) {
        try {
            Class commandClass = Class.forName(BASE_COMMAND_PACKAGE + name + COMMAND_SUFFIX);
            Constructor<Command> constuctor = commandClass.getDeclaredConstructors()[0];
            return constuctor.newInstance(args);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
