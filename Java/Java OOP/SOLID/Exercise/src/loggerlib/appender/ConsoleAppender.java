package loggerlib.appender;

import loggerlib.appender.interfaces.Appender;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.interfeces.Layout;

public class ConsoleAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.setReportLevel(reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.layout.format(date, reportLevel, message));
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
}
