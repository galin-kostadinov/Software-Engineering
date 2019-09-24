import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RemoveOddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            occurrences.putIfAbsent(numbers[i], 0);
            occurrences.put(numbers[i], occurrences.get(numbers[i]) + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (occurrences.get(numbers[i]) % 2 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }
}
