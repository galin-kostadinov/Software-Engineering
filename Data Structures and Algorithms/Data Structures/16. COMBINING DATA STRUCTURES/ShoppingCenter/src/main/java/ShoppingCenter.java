import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCenter {
    private Multimap<String, Product> byProducer;
    private Multimap<String, Product> byName;
    private Multimap<Double, Product> byPrice;

    public ShoppingCenter() {
        this.byProducer = TreeMultimap.create(Comparator.naturalOrder(), Comparator.naturalOrder());
        this.byName = TreeMultimap.create(Comparator.naturalOrder(), Comparator.naturalOrder());
        this.byPrice = TreeMultimap.create(Comparator.naturalOrder(), Comparator.naturalOrder());
    }

    public void add(Product product) {
        this.byProducer.put(product.getProducer(), product);
        this.byName.put(product.getName(), product);
        this.byPrice.put(product.getPrice(), product);
    }

    public int deleteProductsByProducer(String producer) {
        if (!this.byProducer.containsKey(producer)) {
            return 0;
        }

        Iterable<Product> productToRemove = this.byProducer.get(producer);

        int count = 0;

        for (Product product : productToRemove) {
            String name = product.getName();
            this.byName.get(name).remove(product);
            this.byPrice.get(product.getPrice()).remove(product);
            count++;
        }

        this.byProducer.removeAll(producer);
        return count;
    }

    public int deleteProductsByProducerAndName(String producerName, String producer) {
        if (!this.byProducer.containsKey(producer)) {
            return 0;
        }

        Iterable<Product> productToRemove = this.byProducer.get(producer);

        int count = 0;

        for (Product product : productToRemove) {
            if (product.getName().equals(producerName)) {
                this.byName.get(producerName).remove(product);
                this.byPrice.get(product.getPrice()).remove(product);
                this.byProducer.get(producer).remove(product);
                count++;
            }
        }


        return count;
    }

    public Iterable<Product> findProductsByName(String name) {
        if (!this.byName.containsKey(name)) {
            return null;
        }

        return byName.get(name);
    }

    public Iterable<Product> findProductsByProducer(String producer) {
        if (!this.byProducer.containsKey(producer)) {
            return null;
        }

        return byProducer.get(producer);
    }

    public Iterable<Product> findProductsByPriceRange(double low, double higth) {
        List<Product> result = new ArrayList<>();

        for (var kvp : this.byPrice.entries()) {
            if (kvp.getKey() >= low && kvp.getKey() <= higth) {
                result.add(kvp.getValue());
            }
        }

        return result;
    }
}
