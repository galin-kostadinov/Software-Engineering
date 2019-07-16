package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int magicNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            int magicSum = 0;
            int firstNum = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int secondNum = numbers[j];
                magicSum = firstNum + secondNum;

                if (magicSum == magicNumber) {
                    System.out.printf("%d %d%n", firstNum, secondNum);
                }
            }
        }
    }
}
