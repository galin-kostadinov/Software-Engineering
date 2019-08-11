package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] splitInput = reader.readLine().split(", ");

        Function<String, Integer> parse = s -> Integer.parseInt(s);

        List<Integer> numbers = Arrays.stream(splitInput)
                .map(parse)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);
    }
}
