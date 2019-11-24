import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(reader.readLine());

        ShoppingCenter center = new ShoppingCenter();

        for (int i = 0; i < commandCount; i++) {
            String line = reader.readLine();
            int firstSpace = line.indexOf(' ');
            String command = line.substring(0, firstSpace);

            String[] tokens = line.substring(firstSpace + 1).split(";");

            Iterable<Product> result = null;

            switch (command) {
                case "AddProduct":
                    String name = tokens[0];
                    double price = Double.parseDouble(tokens[1]);
                    String producer = tokens[2];

                    Product p = new Product(name, price, producer);
                    center.add(p);

                    System.out.println("Product added");
                    break;
                case "DeleteProducts":
                    int count = 0;

                    if (tokens.length == 1) {
                        count = center.deleteProductsByProducer(tokens[0]);
                    } else {
                        count = center.deleteProductsByProducerAndName(tokens[0], tokens[1]);
                    }

                    if (count > 0) {
                        System.out.println(count + " products deleted");
                    } else {
                        System.out.println("No products found");
                    }

                    break;
                case "FindProductsByName":
                    result = center.findProductsByName(tokens[0]);

                    if (result != null) {
                        for (Product product : result) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found");
                    }

                    break;
                case "FindProductsByProducer":
                    result = center.findProductsByProducer(tokens[0]);

                    if (result != null) {
                        for (Product product : result) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found");
                    }
                    break;
                case "FindProductsByPriceRange":
                    result = center.findProductsByPriceRange(
                            Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));

                    if (result != null) {
                        for (Product product : result) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
