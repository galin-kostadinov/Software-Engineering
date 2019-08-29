import loggerlib.appender.ConsoleAppender;
import loggerlib.appender.interfaces.Appender;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.SimpleLayout;
import loggerlib.layout.interfeces.Layout;

public class Main {
    public static void main(String[] args) {

        Layout layout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(layout);
        consoleAppender.append("3/26/2015 2:08:11 PM",
                ReportLevel.INFO,
                "Error parsing JSON.");
    }
}
