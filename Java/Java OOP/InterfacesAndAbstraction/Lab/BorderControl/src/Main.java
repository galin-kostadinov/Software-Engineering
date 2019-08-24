import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        List<Identifiable> all = new ArrayList<>();

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");

            if (tokens.length == 2) {
                String model = tokens[0];
                String id = tokens[1];

                Robot robot = new Robot(model, id);
                all.add(robot);
            } else if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Citizen citizen = new Citizen(name, age, id);
                all.add(citizen);
            }
        }

        String searchedPartFromId = reader.readLine();
        for (Identifiable element : all) {
            if (element.getId().endsWith(searchedPartFromId)) {
                System.out.println(element.getId());
            }
        }
    }
}
