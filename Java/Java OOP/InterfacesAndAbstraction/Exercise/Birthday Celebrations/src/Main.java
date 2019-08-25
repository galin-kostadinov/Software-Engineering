import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthableList = new ArrayList<>();
        List<Identifiable> robot = new ArrayList<>();
        String input;

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];

            if (type.equals("Citizen")) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthday = tokens[4];
                birthableList.add(new Citizen(name, age, id, birthday));
            } else if (type.equals("Pet")) {
                String name = tokens[1];
                String birthday = tokens[2];
                birthableList.add(new Pet(name, birthday));
            } else if (type.equals("Robot")) {
                String model = tokens[1];
                String id = tokens[2];

                robot.add(new Robot(model, id));
            }
        }

        String year = reader.readLine();

        for (Birthable birthable : birthableList) {
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
