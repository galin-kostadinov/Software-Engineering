package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Function<String, Integer> mapper = Integer::parseInt;

        Map<Integer, Predicate<Integer>> predicateMap = new HashMap<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(mapper)
                .forEach(divider -> {
                    if (!predicateMap.containsKey(divider)) {
                        Predicate<Integer> predicate = num -> num % divider == 0;
                        predicateMap.put(divider, predicate);
                    }
                });

        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean[] isDivisible = {true};

            predicateMap.forEach((k, v) -> {
                if (!v.test(num)) {
                    isDivisible[0] = false;
                }

            });

            if (isDivisible[0]) {
                System.out.print(num + " ");
            }
        }

        System.out.println();
    }
}
