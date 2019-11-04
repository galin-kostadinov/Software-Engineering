package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap();
        Map<String, Product> products = new LinkedHashMap();

        String[] namesAndMoney = reader.readLine().trim().split(";");

        for (String nameProduct : namesAndMoney) {
            String name = nameProduct.substring(0, nameProduct.indexOf("=")).trim();
            double money = Double.parseDouble(nameProduct.substring(nameProduct.indexOf("=") + 1).trim());
            try {
                Person person = new Person(name, money);
                people.putIfAbsent(name, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String[] productsAndPrice = reader.readLine().trim().split(";");

        for (String productPrice : productsAndPrice) {
            String name = productPrice.substring(0, productPrice.indexOf("=")).trim();
            double price = Double.parseDouble(productPrice.substring(productPrice.indexOf("=") + 1).trim());

            try {
                Product product = new Product(name, price);
                products.putIfAbsent(name, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String input;

        while (!"END".equalsIgnoreCase(input = reader.readLine())) {
            String personName = input.substring(0, input.lastIndexOf(" ")).trim();
            String productName = input.substring(input.lastIndexOf(" ")).trim();

            Person person = people.get(personName);

            try {
                person.buyProduct(products.get(productName));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Person person : people.values()) {
            System.out.println(person.toString());
        }
    }
}
