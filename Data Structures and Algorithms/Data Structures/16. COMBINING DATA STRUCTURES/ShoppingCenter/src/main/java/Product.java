public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private String producer;

    public Product(String name, double price, String producer) {
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public int compareTo(Product other) {
        int compare = this.name.compareTo(other.name);
        if (compare == 0) {
            compare = this.producer.compareTo(other.producer);

            if (compare == 0) {
                return Double.compare(this.price, other.price);
            }
        }

        return compare;
    }

    @Override
    public String toString() {
        return String.format("{%s;%s;%.2f}",
                this.getName(),
                this.getProducer(),
                this.getPrice());
    }
}
