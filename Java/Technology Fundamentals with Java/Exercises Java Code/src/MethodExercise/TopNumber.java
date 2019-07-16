package MethodExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        printTopNumbers(number);
    }

    private static void printTopNumbers(int number) {

        for (int i = 8; i <= number; i++) {
            String numberLikeString = i + "";
            boolean isDivisible = isSumDivisibelBy8(numberLikeString);
            boolean isNumHoldOdd = isNumberHoldsOdd(numberLikeString);

            if (isDivisible && isNumHoldOdd) {
                System.out.println(i);
            }
        }


    }

    private static boolean isNumberHoldsOdd(String numberLikeString) {

        for (int i = 0; i <numberLikeString.length() ; i++) {
            int currenNumber = numberLikeString.charAt(i)-'0';
            if (currenNumber%2!=0){
                return true;
            }
        }
        return false;
    }

    private static boolean isSumDivisibelBy8(String numberLikeString) {
        int sum = 0;
        for (int i = 0; i < numberLikeString.length(); i++) {
            sum += numberLikeString.charAt(i) - '0';
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;
    }
}
