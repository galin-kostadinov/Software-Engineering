package loggerlib.layout;

import loggerlib.layout.interfeces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, String reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel, message);
    }
}
