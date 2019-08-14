package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String input;

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            people.putIfAbsent(personName, new Person(personName));

            String dataType = tokens[1];
            switch (dataType) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    people.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    people.get(personName).addPokemons(pokemon);
                    break;
                case "parents":
                    Parant parent = new Parant(tokens[2], tokens[3]);
                    people.get(personName).addParants(parent);
                    break;
                case "children":
                    Child child = new Child(tokens[2], tokens[3]);
                    people.get(personName).addChildren(child);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    people.get(personName).setCar(car);
                    break;
            }
        }

        String personName = reader.readLine();
        Person person = people.get(personName);

        System.out.println(person.getPersonName());

        System.out.println("Company:");
        String companyToPrint = person.getCompany() != null ? person.getCompany().toString() : "";
        System.out.printf("%s", companyToPrint);

        System.out.println("Car:");
        String carToPrint = person.getCar() != null ? person.getCar().toString() : "";
        System.out.printf("%s", carToPrint);

        System.out.println("Pokemon:");
        person.getPokemons().forEach(p-> System.out.println(p.toString()));

        System.out.println("Parents:");
        person.getParants().forEach(p-> System.out.println(p.toString()));

        System.out.println("Children:");
        person.getChildren().forEach(p-> System.out.println(p.toString()));
    }
}
