package SetsAndMapsAdvanced_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input;

        while (!"Revision".equals(input = sc.nextLine())) {
            String[] tokens = input.split(",\\s+");
            String shopName = tokens[0];
            String productName = tokens[1];
            double productPrice = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).putIfAbsent(productName, productPrice);
        }

        shops.forEach((shopName, products) -> {
            System.out.println(shopName + "->");
            products.forEach((productName, price) ->
                    System.out.println(String.format("Product: %s, Price: %.1f",
                            productName,
                            price)));
        });
    }
}
