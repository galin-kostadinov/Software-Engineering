package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n ; i++) {
            int[] intArray = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (i%2==0){
                firstArray[i] = intArray[0];
                secondArray[i] = intArray[1];
            } else {
                firstArray[i] = intArray[1];
                secondArray[i] = intArray[0];
            }
        }
        for (int number: firstArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number: secondArray) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
