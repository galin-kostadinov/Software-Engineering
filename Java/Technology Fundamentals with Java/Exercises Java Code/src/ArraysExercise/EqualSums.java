package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum+=numbers[j];
            }
            for (int j = i+1; j < numbers.length; j++) {
                rightSum+=numbers[j];
            }
            if (leftSum==rightSum){
                System.out.println(i);
                break;
            }
            if (i==numbers.length-1){
                System.out.println("no");
            }
        }


    }
}
