package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeneratingCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] set = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cols = Integer.parseInt(reader.readLine());

        int[] vector = new int[cols];
        generator(set, vector, 0, 0);
    }

    private static void generator(int[] set, int[] vector, int index, int border) {
        if (index == vector.length) {
            print(vector);
        } else {
            for (int i = border; i < set.length; i++) {
                vector[index] = set[i];
                generator(set, vector, index + 1, i + 1);
            }
        }
    }

    private static void print(int[] vector) {
        for (int value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
