package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan =
                (person, ageLimit) -> person.getValue() < ageLimit;

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
                (person, ageLimit) -> person.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName =
                person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String, Integer>> printAge =
                person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String, Integer>> printNameAndAge =
                person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        Map<String, Integer> people = new LinkedHashMap<>();

        int peopleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] personData = reader.readLine().split(", ");

            people.put(personData[0], Integer.parseInt(personData[1]));
        }

        String comparison = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String printType = reader.readLine();

        Consumer<Map.Entry<String, Integer>> print = printNameAndAge;

        if (printType.equals("age")) {
            print = printAge;
        } else if (printType.equals("name")) {
            print = printName;
        }

        BiPredicate<Map.Entry<String, Integer>, Integer> byAge = youngerThan;

        if (comparison.equals("older")) {
            byAge = olderThan;
        }

        BiPredicate<Map.Entry<String, Integer>, Integer> finalByAge = byAge;

        people.entrySet()
                .stream()
                .filter(person -> finalByAge.test(person, ageLimit))
                .forEach(print);
    }
}
