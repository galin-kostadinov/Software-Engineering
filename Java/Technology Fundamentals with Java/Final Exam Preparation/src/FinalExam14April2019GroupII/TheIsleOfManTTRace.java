package FinalExam14April2019GroupII;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "([#$%*&]{1})(?<name>[A-Za-z]+)\\1=(?<length>[0-9]+)!!(?<encryptedGeohashCode>.+)";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            String name = "";
            int length = 0;
            String encryptedGeohashCode = "";
            boolean isFound = false;
            if (matcher.find()) {
                name = matcher.group("name");
                length = Integer.parseInt(matcher.group("length"));
                encryptedGeohashCode = matcher.group("encryptedGeohashCode");
                if (length == encryptedGeohashCode.length()) {
                    isFound = true;
                }
            }

            if (isFound) {
                StringBuilder geohashCode = new StringBuilder(length);
                for (int i = 0; i < encryptedGeohashCode.length(); i++) {
                    char symbol = (char)(encryptedGeohashCode.charAt(i) + length);
                    geohashCode.append(symbol);
                }

                System.out.printf("Coordinates found! %s -> %s", name, geohashCode);
                return;
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
