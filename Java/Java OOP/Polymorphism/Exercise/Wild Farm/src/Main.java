import animal.*;
import food.Food;
import food.Meat;
import food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] animalTokens = input.split("\\s+");

            String[] foodTokens = reader.readLine().split("\\s+");

            Animal animal = produceAnimal(animalTokens);
            Food food = produceFood(foodTokens);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Food produceFood(String[] foodTokens) {
        Food food = null;

        String type = foodTokens[0];

        if (type.equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodTokens[1]));
        } else if (type.equals("Meat")) {
            food = new Meat(Integer.parseInt(foodTokens[1]));
        }

        return food;
    }

    private static Animal produceAnimal(String[] tokens) {
        Animal animal = null;

        String type = tokens[0];

        if (type.equals("Mouse")) {
            animal = new Mouse(tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3]);
        } else if (type.equals("Zebra")) {
            animal = new Zebra(tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3]);
        } else if (type.equals("Cat")) {
            animal = new Cat(tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3],
                    tokens[4]);
        } else if (type.equals("Tiger")) {
            animal = new Tiger(tokens[1],
                    tokens[0],
                    Double.parseDouble(tokens[2]),
                    tokens[3]);
        }

        return animal;
    }
}
