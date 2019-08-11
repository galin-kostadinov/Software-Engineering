package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> evenNums = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        List<String> evenNumToString = evenNums.stream().map(String::valueOf).collect(Collectors.toList());

        evenNums.sort(Comparator.naturalOrder());

        List<String> evenSortedNumToString = evenNums.stream().map(String::valueOf).collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumToString));
        System.out.println(String.join(", ", evenSortedNumToString));
    }
}
