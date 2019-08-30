import loggerlib.appender.ConsoleAppender;
import loggerlib.appender.FileAppender;
import loggerlib.appender.interfaces.Appender;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.SimpleLayout;
import loggerlib.layout.XmlLayout;
import loggerlib.layout.interfeces.Layout;
import loggerlib.loggers.MessageLogger;
import loggerlib.loggers.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Appender[] appenders = new Appender[n];

        int index = 0;

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            Appender appender = null;

            Layout layout = null;

            if (tokens[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }

            if (tokens[0].equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else {
                appender = new FileAppender(layout);
            }

            if (tokens.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
            }

            appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");

            switch (ReportLevel.valueOf(tokens[0])) {
                case INFO:
                    logger.logInfo(tokens[1], tokens[2]);
                    break;
                case ERROR:
                    logger.logError(tokens[1], tokens[2]);
                    break;
                case FATAL:
                    logger.logFatal(tokens[1], tokens[2]);
                    break;
                case WARNING:
                    logger.logWarning(tokens[1], tokens[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(tokens[1], tokens[2]);
                    break;
            }
        }

        System.out.println(logger.toString());
    }
}
