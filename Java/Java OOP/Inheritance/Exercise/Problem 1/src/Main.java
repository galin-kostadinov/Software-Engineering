
import animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*
        Used for animals package:

        List<Animal> animals = new ArrayList<>();

        String type;
        while (!"Beast!".equalsIgnoreCase(type = reader.readLine())) {
            String[] token = reader.readLine().split("\\s+");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            String gender = token[2];

            if (age < 0) {
                System.out.println("Invalid input!");
                continue;
            }

            if (type.equals("Cat")) {
                Cat cat = new Cat(name, age, gender);
                animals.add(cat);
            } else if (type.equals("Dog")) {
                Dog dog = new Dog(name, age, gender);
                animals.add(dog);
            } else if (type.equals("Frog")) {
                Frog frog = new Frog(name, age, gender);
                animals.add(frog);
            } else if (type.equals("Kitten")) {
                Kitten kitten = new Kitten(name, age);
                animals.add(kitten);
            } else if (type.equals("Tomcat")) {
                Tomcat tomcat = new Tomcat(name, age);
                animals.add(tomcat);
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
        */


        /*
          Used for person package:

          String name = reader.readLine();
          int age = Integer.parseInt(reader.readLine());

          Child child = new Child(name, age);

          System.out.println(child.getName());
          System.out.println(child.getAge());
        */
    }
}
