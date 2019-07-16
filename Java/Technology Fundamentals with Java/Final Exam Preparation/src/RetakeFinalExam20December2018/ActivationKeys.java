package RetakeFinalExam20December2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("&");
        String regex = "^([A-Za-z0-9]{25})$|^([A-Za-z0-9]{16})$";
        Pattern pattern = Pattern.compile(regex);

        List<String> keys = new ArrayList<>(input.length);

        for (int i = 0; i < input.length; i++) {
            String currentKey = input[i];
            Matcher matcher = pattern.matcher(currentKey);
            if (matcher.find()) {
                currentKey = currentKey.toUpperCase();
                String realKey = realKeyCreator(currentKey);
                keys.add(realKey);
            }
        }
        System.out.println(String.join(", ", keys));

    }

    private static String realKeyCreator(String currentKey) {
        StringBuilder realKey = new StringBuilder();

        for (int i = 0; i < currentKey.length(); i++) {
            char currentSymbol = currentKey.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                int number = 9 - (currentSymbol - '0');
                realKey.append(number);
            } else {
                realKey.append(currentSymbol);
            }

            if ((i + 1) % 4 == 0 && i < (currentKey.length() - 1)
                    && currentKey.length() == 16) {
                realKey.append('-');
            } else if ((i + 1) % 5 == 0 && i < (currentKey.length() - 1)
                    && currentKey.length() == 25) {
                realKey.append('-');
            }
        }
        return realKey.toString();
    }
}