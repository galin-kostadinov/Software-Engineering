package EqualityLogic;

import StrategyPattern.PersonByAge;
import StrategyPattern.PersonByName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> personTreeSet = new TreeSet<>();
        HashSet<Person> personHashSet = new HashSet<>();

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personTreeSet.add(person);
            personHashSet.add(person);
        }

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());
    }
}
