package loggerlib.layout;

import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.interfeces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel.toString(), message);
    }
}
