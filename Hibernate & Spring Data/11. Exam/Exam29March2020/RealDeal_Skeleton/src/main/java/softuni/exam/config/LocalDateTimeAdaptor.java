package softuni.exam.config;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdaptor extends XmlAdapter<String, LocalDateTime> {
    private static DateTimeFormatter DATE_FORMAT_FROM_STRING = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter DATE_FORMAT_TO_STRING = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public String marshal(LocalDateTime dateTime) {
        return dateTime.format(DATE_FORMAT_TO_STRING);
    }

    @Override
    public LocalDateTime unmarshal(String dateTime) {
        return LocalDateTime.parse(dateTime, DATE_FORMAT_FROM_STRING);
    }
}
