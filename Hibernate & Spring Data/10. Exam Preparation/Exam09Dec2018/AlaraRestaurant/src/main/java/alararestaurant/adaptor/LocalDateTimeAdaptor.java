package alararestaurant.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdaptor extends XmlAdapter<String, LocalDateTime> {
    private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public String marshal(LocalDateTime dateTime) {
        return dateTime.format(DATE_FORMAT);
    }

    @Override
    public LocalDateTime unmarshal(String dateTime) {
        return LocalDateTime.parse(dateTime, DATE_FORMAT);
    }
}
