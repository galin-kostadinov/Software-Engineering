package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] biggerNumbers = new int[numbers.length];
        for (int i = 0; i < biggerNumbers.length; i++) {
            biggerNumbers[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            boolean isBigger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isBigger = false;
                }
            }
            if (isBigger) {
                biggerNumbers[i] = numbers[i];
            }
        }
        biggerNumbers[biggerNumbers.length - 1] = numbers[numbers.length - 1];

        biggerNumbers = Arrays.stream(biggerNumbers).filter(e -> e > Integer.MIN_VALUE).toArray();

        for (int num : biggerNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
