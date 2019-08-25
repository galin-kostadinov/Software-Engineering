import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int commandNumber = Integer.parseInt(reader.readLine());

        Map<String, Buyer> buyers = new HashMap<>();

        while (commandNumber-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (tokens.length == 3) {
                String group = tokens[2];

                buyers.put(name, new Rebel(name, age, group));
            } else if (tokens.length == 4) {
                String id = tokens[2];
                String birthDate = tokens[3];

                buyers.put(name, new Citizen(name, age, id, birthDate));
            }
        }

        String name;

        while (!"End".equals(name = reader.readLine())) {
            for (Map.Entry<String, Buyer> stringBuyerEntry : buyers.entrySet()) {
                String nameInMap = stringBuyerEntry.getKey();

                if (nameInMap.equals(name)) {
                    stringBuyerEntry.getValue().buyFood();
                }
            }
        }

        int sum = buyers.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(sum);
    }
}
