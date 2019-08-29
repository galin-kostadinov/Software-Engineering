package loggerlib.appender;

import loggerlib.appender.interfaces.Appender;

public class ConsoleAppender implements Appender {
    @Override
    public void append() {
        System.out.println();
    }
}
