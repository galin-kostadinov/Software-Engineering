package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wagonsCount = Integer.parseInt(sc.nextLine());
        int[] train = new int[wagonsCount];

        for (int i = 0; i < train.length; i++) {
            int input = Integer.parseInt(sc.nextLine());
            train[i] = input;
        }

        int sum = Arrays.stream(train).sum();

        for (int people : train) {
            System.out.print(people + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
