package DaraTypesVariableExercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numberAsString = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < numberAsString.length(); i++) {
            int currentDigit = numberAsString.charAt(i) - '0';
            sum += currentDigit;
        }
        System.out.println(sum);
    }
}

