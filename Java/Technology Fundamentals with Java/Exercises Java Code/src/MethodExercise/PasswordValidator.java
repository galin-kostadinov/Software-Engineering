package MethodExercise;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();

        boolean lengthInRange = isPasswordLengthTrue(password);
        boolean contentRestriction = isPasswordConsistOnlyDigitsAndLetters(password);
        boolean consistMinCountDigits = isPasswordConsistMinCountDigits(password);

        if (lengthInRange && contentRestriction && consistMinCountDigits) {
            System.out.println("Password is valid");
        }
        if (!lengthInRange) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!contentRestriction) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!consistMinCountDigits) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    private static boolean isPasswordConsistMinCountDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Pattern.matches("[0-9]+", password.charAt(i) + "")) {
                count++;
            }
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }

    static boolean isPasswordLengthTrue(String password) {
        boolean isTrue = (password.length() >= 6 && password.length() <= 10) ? true : false;
        return isTrue;
    }

    static boolean isPasswordConsistOnlyDigitsAndLetters(String password) {
        if (password.matches("[a-zA-z0-9]+")) {
            return true;
        }
        return false;
    }

    static boolean consistOnlyDigitsAndLetters(String password) {
        boolean isValid = true;

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
