package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int digit = numbers[0];
        int digitsCount = 1;
        int currentDigit = numbers[0];
        int currentDigitCount = 1;

        for (int i = 0; i < numbers.length - 1; i++) {

            if (numbers[i] == numbers[i + 1]) {
                int saveDigit = currentDigit;
                currentDigit = numbers[i];
                if (saveDigit == currentDigit) {
                    currentDigitCount++;
                } else {
                    currentDigitCount = 2;
                }

            } else {
                currentDigitCount = 1;
            }
            if (digitsCount < currentDigitCount) {
                digit = currentDigit;
                digitsCount = currentDigitCount;
            }
        }

        for (int i = 0; i < digitsCount; i++) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}
