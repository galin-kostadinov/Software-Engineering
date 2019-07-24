package FinalExam16December2018;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regexValidation = "^(?<artist>[A-Z]{1}[a-z\\s']+):(?<song>[A-Z\\s]+[A-Z]+)$";
        Pattern patternValidation = Pattern.compile(regexValidation);

        String input = "";
        while (!"end".equals(input = sc.nextLine())) {
            Matcher matcherValidation = patternValidation.matcher(input);
            if (!matcherValidation.find()) {
                System.out.println("Invalid input!");
                continue;
            }

            int key = matcherValidation.group("artist").length();

            StringBuilder output = new StringBuilder(input.length());
            for (int i = 0; i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isLetter(currentSymbol)) {
                    char newLetter = (char) (currentSymbol + key);
                    if (Character.isLowerCase(currentSymbol)) {
                        while (newLetter > 'z') {
                            newLetter -= (char) ('z' - 'a' + 1);
                        }
                    } else {
                        while (newLetter > 'Z') {
                            newLetter -= (char) ('Z' - 'A' + 1);
                        }
                    }
                    output.append(newLetter);
                } else if (Character.isWhitespace(currentSymbol)) {
                    output.append(' ');
                } else if (currentSymbol == '\'') {
                    output.append('\'');
                } else if (currentSymbol == ':') {
                    output.append('@');
                }
            }
            System.out.printf("Successful encryption: %s%n", output);
        }
    }
}
