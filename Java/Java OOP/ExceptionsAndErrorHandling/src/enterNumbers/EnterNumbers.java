package enterNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                int start = Integer.parseInt(reader.readLine());
                int end = Integer.parseInt(reader.readLine());

                printNumbers(start, end);

                return;
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid numbers!");
                System.out.println("Try again:");
            }
        }
    }

    public static void printNumbers(int start, int end) {
        if (start <= 1 || end >= 100 || start > end) {
            throw new IllegalArgumentException();
        }

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
