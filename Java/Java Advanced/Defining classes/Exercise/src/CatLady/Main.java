package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> cats = new HashMap<>();

        String data;
        while (!"End".equals(data = reader.readLine())) {
            String[] tokens = data.split("\\s+");

            String breed = tokens[0];
            String name = tokens[1];
            double specialData = Double.parseDouble(tokens[2]);

            Cat cat = null;

            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, specialData);
                    break;
                case "Cymric":
                    cat = new Cymric(name, specialData);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, specialData);
                    break;
            }

            cats.putIfAbsent(name, cat);
        }

        String catNameToPrint = reader.readLine();

        Cat cat = cats.get(catNameToPrint);

        System.out.println(cat.toString());
    }
}
