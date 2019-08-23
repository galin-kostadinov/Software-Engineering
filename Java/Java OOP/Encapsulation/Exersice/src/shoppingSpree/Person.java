package shoppingSpree;

import java.util.ArrayList;
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

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        double leftMoney = this.money - product.getCost();
        if (leftMoney < 0) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
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
            StringBuilder sb = new StringBuilder(products.toString());
            result = String.format("%s - %s", this.name, sb.toString().substring(1, sb.length() - 1));
        }

        return result;
    }
}
