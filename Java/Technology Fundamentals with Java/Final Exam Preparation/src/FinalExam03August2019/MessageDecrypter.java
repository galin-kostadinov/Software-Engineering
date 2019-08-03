package FinalExam03August2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "^([$|%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<firstDigit>\\d+)]\\|\\[(?<secondDigit>\\d+)]\\|"
                + "\\[(?<thirdDigit>\\d+)]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                int firstDigit = Integer.parseInt(matcher.group("firstDigit"));
                int secondDigit = Integer.parseInt(matcher.group("secondDigit"));
                int thirdDigit = Integer.parseInt(matcher.group("thirdDigit"));

                System.out.printf("%s: %c%c%c%n", tag, firstDigit, secondDigit, thirdDigit);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
