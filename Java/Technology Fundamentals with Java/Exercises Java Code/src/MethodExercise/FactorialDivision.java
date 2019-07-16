package MethodExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int firstNum = Integer.parseInt(reader.readLine());
        int secondNum = Integer.parseInt(reader.readLine());

        long firstNumFactorial = factorial(firstNum);
        long secondNumFactorial = factorial(secondNum);

        double result = 1.00 * firstNumFactorial / secondNumFactorial;

        System.out.printf("%.2f", result);
    }

    private static long factorial(int number) {
        long result = 1;

        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
