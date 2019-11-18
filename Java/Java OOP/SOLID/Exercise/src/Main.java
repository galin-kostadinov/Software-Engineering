import loggerlib.appender.interfaces.Appender;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.interfeces.Layout;
import loggerlib.loggers.MessageLogger;
import loggerlib.loggers.interfaces.Logger;
import loggerlib.parsecommand.AppenderParser;
import loggerlib.parsecommand.LayoutParser;
import loggerlib.parsecommand.LoggerParser;

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

            Layout layout = LayoutParser.createLayout(tokens[1]);

            Appender appender = AppenderParser.createAppender(tokens[0], layout);

            if (tokens.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
            }

            appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String input;

        while (!"END".equals(input = reader.readLine())) {
            LoggerParser.log(logger, input);
        }

        System.out.println(logger.toString());
    }
}
