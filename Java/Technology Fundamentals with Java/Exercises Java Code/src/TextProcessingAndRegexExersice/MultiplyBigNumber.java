package TextProcessingAndRegexExersice;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bigNum = sc.nextLine();
        String smallNumAsString = sc.nextLine();
        if (bigNum.length() < smallNumAsString.length()) {
            String changer = bigNum;
            bigNum = smallNumAsString;
            smallNumAsString = changer;
        }
        int smallNum = Integer.parseInt(smallNumAsString);

        String sign = "";
        if (bigNum.charAt(0) == '-' && smallNum > 0) {
            sign = "-";
            bigNum = bigNum.substring(1);
        } else if (bigNum.charAt(0) != '-' && smallNum < 0) {
            sign = "-";
            smallNum *= -1;
        } else if (bigNum.charAt(0) == '-' && smallNum < 0) {
            smallNum *= -1;
            bigNum = bigNum.substring(1);
        }

        while (bigNum.charAt(0) == '0') {
            bigNum = bigNum.substring(1);
        }
        StringBuilder sum = new StringBuilder();
        int rest = 0;

        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int number = (bigNum.charAt(i) - '0');
            int result = number * smallNum + rest;

            if (result > 9) {
                String resultAsString = result + "";
                rest = resultAsString.charAt(0) - '0';
                sum.append(resultAsString.charAt(1));
            } else {
                rest = 0;

                String resultAsString = result + "";
                sum.append(resultAsString.charAt(0));

            }
        }

        if (rest > 0) {
            String restAsString = rest + "";
            sum.append(restAsString.charAt(0));
        }

        sum.reverse();
        if (sum.charAt(0) == '0') {
            System.out.println(0);
        } else {
            if (!sign.equals("-")) {
                System.out.println(sum);
            } else {
                System.out.printf("-%s%n", sum);
            }
        }
    }
}
