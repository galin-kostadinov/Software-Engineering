package AssociativeArrEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedHashMap;

public class Orders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Double> prices = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> quantites = new LinkedHashMap<>();

        String input = "";

        while (!"buy".equals(input = reader.readLine())) {
            String[] token = input.split("\\s+");
            String product = token[0];
            double price = Double.parseDouble(token[1]);
            int quantity = Integer.parseInt(token[2]);

            if (!prices.containsKey(product)) {
                prices.put(product, price);
                quantites.put(product, 0);
            }
            quantites.put(product, quantites.get(product) + quantity);
            if (prices.get(product) != price) {
                prices.put(product, price);
            }
        }

        prices.forEach((product, value) -> {
            double price = value;
            int quantity = quantites.get(product);
            double result = price * quantity;
            System.out.println(String.format("%s -> %.2f", product, result));
        });
//2:21h
    }
}
