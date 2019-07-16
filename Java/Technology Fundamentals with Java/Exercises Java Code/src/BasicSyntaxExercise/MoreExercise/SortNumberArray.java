package BasicSyntaxExercise.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class SortNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = Integer.parseInt(sc.nextLine());
        int num2 = Integer.parseInt(sc.nextLine());
        int num3 = Integer.parseInt(sc.nextLine());

        int[] numbers = {num1, num2, num3};
        Arrays.sort(numbers);

        for (int i = numbers.length-1; i >=0 ; i--) {
            System.out.println(numbers[i]);
        }
    }
}
