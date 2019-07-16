package TextProcessingAndRegexExersice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MultiplyBigNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        while (num1.charAt(0) == '0') {
            num1 = num1.substring(1);
        }
        int num2 = Integer.parseInt(sc.nextLine());
        if (num2 == 0) {
            System.out.println(0);
            return;
        }
        int decimalReminder = 0;
        int currentMultiplication = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int currentDigit = num1.charAt(i) - '0';
            currentMultiplication = currentDigit * num2;
            currentMultiplication += decimalReminder;
            result.add(currentMultiplication % 10);
            decimalReminder = currentMultiplication / 10;
        }
        if (decimalReminder > 0) {
            result.add(decimalReminder);
        }
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%d", result.get(i));
        }
        System.out.println();

    }
}
