package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+".trim());
        ArrayDeque<String> calc = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0; i--) {
            String currentElement = input[i];
            calc.push(currentElement);
        }

        while (calc.size() > 1) {
            int firstDigit = Integer.parseInt(calc.pop());
            String operator = calc.pop();
            int secondDigit = Integer.parseInt(calc.pop());

            if (operator.equals("+")) {
                int result = firstDigit + secondDigit;
                calc.push(result + "");
            } else {
                int result = firstDigit - secondDigit;
                calc.push(result + "");
            }
        }

        System.out.println(calc.peek());
    }
}
