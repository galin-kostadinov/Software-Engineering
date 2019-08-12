package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minNumber = arr -> {
            int min = arr.stream().mapToInt(Integer::intValue).min().getAsInt();
            return arr.lastIndexOf(min);
        };

        System.out.println(minNumber.apply(numbers));
    }
}
