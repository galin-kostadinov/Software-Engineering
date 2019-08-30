import loggerlib.appender.ConsoleAppender;
import loggerlib.appender.FileAppender;
import loggerlib.appender.interfaces.Appender;
import loggerlib.customFiles.LogFile;
import loggerlib.customFiles.interfaces.File;
import loggerlib.layout.SimpleLayout;
import loggerlib.layout.interfeces.Layout;
import loggerlib.loggers.MessageLogger;
import loggerlib.loggers.interfaces.Logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);


        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
        System.out.println(file.getSize());
    }
}
