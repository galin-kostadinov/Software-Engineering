package loggerlib.appender;

import loggerlib.appender.interfaces.Appender;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.interfeces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int loggerMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
        this.loggerMessages = 0;
    }

    protected AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.setReportLevel(reportLevel);
        this.loggerMessages = 0;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected String format(String date, ReportLevel reportLevel, String message) {
        this.loggerMessages++;
        return this.layout.format(date, reportLevel, message);
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public String toString() {
        return String.format(
                "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.toString(),
                this.loggerMessages);
    }
}
