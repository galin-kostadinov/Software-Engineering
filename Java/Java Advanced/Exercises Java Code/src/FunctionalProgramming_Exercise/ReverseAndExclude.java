package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String numAsString = reader.readLine();

        int divider = Integer.parseInt(reader.readLine());

        Predicate<Integer> isDivisible = num -> num % divider != 0;

        Consumer<Integer> print = num -> System.out.printf("%d ", num);

        List<Integer> numbers = Arrays.stream(numAsString.split("\\s+"))
                .map(Integer::parseInt)
                .filter(isDivisible)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        numbers.forEach(print);
    }
}
