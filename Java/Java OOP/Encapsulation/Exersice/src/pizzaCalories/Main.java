package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaInf = reader.readLine().trim().split("\\s+");

        Pizza pizza = new Pizza(pizzaInf[1], Integer.parseInt(pizzaInf[2]));

        String[] doughInf = reader.readLine().trim().split("\\s+");

        Dough dough = new Dough(doughInf[1], doughInf[2],Double.parseDouble(doughInf[3]));

        pizza.setDough(dough);

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] toppingInf = input.trim().split("\\s+");
            Topping topping = new Topping(toppingInf[1], Double.parseDouble(toppingInf[2]));

            pizza.addTopping(topping);
        }

        System.out.println(pizza.toString());
    }
}
