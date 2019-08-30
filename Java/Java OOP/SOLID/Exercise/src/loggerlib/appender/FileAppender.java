package loggerlib.appender;

import loggerlib.customFiles.interfaces.File;
import loggerlib.enumerations.ReportLevel;
import loggerlib.layout.interfeces.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (this.file == null) {
            throw new NullPointerException("File reference not set to an istance of an object");
        }

        this.file.appendBuffer(this.format(date, reportLevel, message));
        this.file.write();
    }
}
