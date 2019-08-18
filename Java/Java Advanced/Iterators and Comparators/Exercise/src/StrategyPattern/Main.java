package StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> peopleByAges = new TreeSet<>(new PersonByAge());
        TreeSet<Person> peopleByNames = new TreeSet<>(new PersonByName());

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            peopleByAges.add(person);
            peopleByNames.add(person);
        }

        for (Person personByName : peopleByNames) {
            System.out.println(personByName);
        }

        for (Person personByAge : peopleByAges) {
            System.out.println(personByAge);
        }
    }
}
