package loggerlib.parsecommand;

import loggerlib.appender.ConsoleAppender;
import loggerlib.appender.FileAppender;
import loggerlib.appender.interfaces.Appender;
import loggerlib.layout.interfeces.Layout;

public class AppenderParser {
    public static Appender createAppender(String type, Layout layout) {
        Appender appender = null;

        if (type.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (type.equals("FileAppender")) {
            appender = new FileAppender(layout);
        }

        return appender;
    }
}
