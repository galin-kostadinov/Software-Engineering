package healthyHeaven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        return products.stream()
                .map(Vegetable::getCalories)
                .reduce(0, Integer::sum);
    }

    public int getProductCount() {
        return products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        String line = String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount());

        StringBuilder sb = new StringBuilder();

        sb.append(line).append(System.lineSeparator());

        for (Vegetable product : products) {
            sb.append(product).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
