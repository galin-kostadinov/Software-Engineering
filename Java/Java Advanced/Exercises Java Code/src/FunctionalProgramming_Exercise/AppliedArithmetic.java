package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

        Function<int[], int[]> increment = arr -> Arrays.stream(arr).map(e -> ++e).toArray();

        UnaryOperator<int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();

        UnaryOperator<int[]> decrement = arr -> Arrays.stream(arr).map(e -> --e).toArray();

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command;

        while (!"end".equals(command = reader.readLine())) {
            switch (command) {
                case "add":
                    numbers = increment.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = decrement.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
}
