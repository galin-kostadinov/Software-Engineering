package loggerlib.parsecommand;

import loggerlib.enumerations.ReportLevel;
import loggerlib.loggers.interfaces.Logger;

public class LoggerParser {
    public static void log(Logger logger, String input) {
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
}
