package loggerlib.layout;

import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.interfeces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("<log>" + System.lineSeparator() +
                        "   <date>%s</date>" + System.lineSeparator() +
                        "   <level>%S</level>" + System.lineSeparator() +
                        "   <message>%s</message>" + System.lineSeparator() +
                        "</log>" + System.lineSeparator(),
                date,
                reportLevel.toString(),
                message);
    }
}
