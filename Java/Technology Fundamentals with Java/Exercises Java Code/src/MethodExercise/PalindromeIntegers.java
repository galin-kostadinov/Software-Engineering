package MethodExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!"END".equals(input = reader.readLine())) {

            printIsPalindrom(input);
        }
    }

    private static void printIsPalindrom(String input) {
        boolean isPalindrom = true;
        for (int i = 0; i <= input.length()/2; i++) {

            char leftSymbol = input.charAt(i);
            char rigthSymbol = input.charAt(input.length() - i - 1);
            if (leftSymbol != rigthSymbol) {
                isPalindrom = false;
            }
        }
        System.out.println(isPalindrom);
    }
}
