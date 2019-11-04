package shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        double leftMoney = this.money - product.getCost();
        if (leftMoney < 0) {
            String message = String.format("%s can't afford %s", this.name, product.getName());
            throw new IllegalArgumentException(message);
        } else {
            System.out.printf("%s bought %s%n", this.name, product.getName());
            this.products.add(product);
            this.money -= product.getCost();
        }
    }

    @Override
    public String toString() {
        String result;

        if (this.products.isEmpty()) {
            result = String.format("%s - Nothing bought", this.name);
        } else {
            String productsList = this.products.toString()
                    .replace("[", "")
                    .replace("]", "");
            result = String.format("%s - %s", this.name, productsList);
        }

        return result;
    }
}
