package loggerlib.layout.interfeces;

public interface Layout {
    String format(String date, String reportLevel, String message);
}
