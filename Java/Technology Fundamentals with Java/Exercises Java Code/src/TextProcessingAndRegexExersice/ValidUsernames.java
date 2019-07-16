package TextProcessingAndRegexExersice;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] passwords = sc.nextLine().split(", ");

        for(String password: passwords){
            if (validatePassLength(password) && isContainsValidSymbols(password)){
                System.out.println(password);
            }
        }
    }

    private static boolean validatePassLength(String password) {
        if (password.length() < 3 || password.length() > 16) {
            return false;
        }
        return true;
    }

    private static boolean isContainsValidSymbols(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))
                    && password.charAt(i) != '_'
                    && password.charAt(i) != '-'
            ) {
                return false;
            }
        }
        return true;
    }
}
