package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+".trim());

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);

            people.add(person);
        }

        int n = Integer.parseInt(reader.readLine());

        if (n < people.size() && n >= 0) {
            Person comparablePerson = people.get(n);

            int[] counter = new int[3];
            counter[2] = people.size();

            for (Person person : people) {
                if (comparablePerson.compareTo(person) == 0) {
                    counter[0]++;
                } else {
                    counter[1]++;
                }
            }

            if (counter[0] != 0) {
                Arrays.stream(counter).forEach(e -> System.out.printf("%d ", e));
            } else {
                System.out.println("No matches");
            }

            System.out.println();
        } else {
            System.out.println("No matches");
        }
    }
}
