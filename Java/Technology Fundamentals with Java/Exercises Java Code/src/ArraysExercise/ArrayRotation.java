package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rotationCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rotationCount; i++) {
            int[] curruntNumber = new int[numbers.length];

            for (int j = 0; j < numbers.length - 1; j++) {
                curruntNumber[j] = numbers[j + 1];
            }
            curruntNumber[curruntNumber.length - 1] = numbers[0];
            numbers = curruntNumber;
        }
        for (int number : numbers) {
            System.out.print(number);
            System.out.print(" ");
        }
        System.out.println();

    }
}
