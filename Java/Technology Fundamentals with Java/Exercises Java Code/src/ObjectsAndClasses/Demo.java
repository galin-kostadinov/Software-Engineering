package ObjectsAndClasses;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {

        LocalDate data = LocalDate.now();
        LocalDate date1 = LocalDate.of(1988, 6, 4);

        System.out.println(date1.getDayOfWeek());
    }
}
