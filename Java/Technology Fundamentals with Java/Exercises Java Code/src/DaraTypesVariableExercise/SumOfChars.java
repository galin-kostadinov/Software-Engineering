package DaraTypesVariableExercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int charCount = Integer.parseInt(sc.nextLine());

        int sum = 0;

        for (int i = 0; i < charCount; i++) {
            char input = sc.nextLine().charAt(0);
            sum += input;
        }

        System.out.printf("The sum equals: %d",sum);
    }
}