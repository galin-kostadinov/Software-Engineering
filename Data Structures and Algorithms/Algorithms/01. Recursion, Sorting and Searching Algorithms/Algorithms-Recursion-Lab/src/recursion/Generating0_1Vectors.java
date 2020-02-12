package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generating0_1Vectors {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] vector = new int[n];
        generator(vector, 0);
    }

    private static void generator(int[] vector, int index) {
        if (index == vector.length) {
            print(vector);
        } else {
            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                generator(vector, index + 1);
            }
        }
    }

    private static void print(int[] vector) {
        for (int value : vector) {
            System.out.print(value);
        }
        System.out.println();
    }
}
