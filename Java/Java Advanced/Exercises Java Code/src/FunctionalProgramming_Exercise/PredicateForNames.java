package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxLength = Integer.parseInt(reader.readLine());

        Predicate<String> nameLength = name -> name.length() <= maxLength;

        Consumer<String> print = name -> System.out.println(name);

        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(nameLength)
                .forEach(print);
    }
}
