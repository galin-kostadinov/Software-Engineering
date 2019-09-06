import exceptions.ArgumentException;
import models.Boat;
import models.RowBoat;
import models.SailBoat;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try {
            Boat b1 = new SailBoat("ivancho", 200, 10);
            Boat b2 = new RowBoat("ivancho", 200, 10);

            Set<Boat> boats = new HashSet<>();

            boats.add(b1);
            boats.add(b2);
            System.out.println();
        } catch (ArgumentException e) {
            e.printStackTrace();
        }
    }
}
