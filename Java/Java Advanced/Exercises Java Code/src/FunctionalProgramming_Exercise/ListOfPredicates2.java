package FunctionalProgramming_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class ListOfPredicates2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ToIntFunction<String> mapper = Integer::parseInt;

        int[] sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(mapper)
                .toArray();

        Predicate<Integer> toPrint = num -> {
            boolean isPrintable = true;

            for (int element : sequence) {
                if (num % element != 0) {
                    isPrintable = false;
                    break;
                }
            }

            return isPrintable;
        };

        for (int i = 1; i <= n; i++) {
            if (toPrint.test(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}
