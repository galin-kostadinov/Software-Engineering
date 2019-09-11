import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product products) {
        return this.products.containsKey(products.getLabel());
    }

    @Override
    public void add(Product products) {
        this.products.put(products.getLabel(), products);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (this.products.containsKey(product)) {
            this.products.get(product).setQuantity(quantity);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if (index >= 0 && index < products.size()) {
            int i = 0;
            for (Product value : products.values()) {
                if (i++ == index) {
                    return value;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Product findByLabel(String label) {
        if (this.products.containsKey(label)) {
            return this.products.get(label);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > this.products.size() || count <= 0) {
            return new ArrayList<>();
        }

        return this.products.values()
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInPriceRange(double lo, double hi) {
        return this.products
                .values()
                .stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.products
                .values()
                .stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (products.values().size() >= count) {
            return products.values()
                    .stream()
                    .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                    .limit(count)
                    .collect(Collectors.toList());
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products
                .values()
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.values().iterator();
    }
}
