package TextProcessingAndRegexExersice;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        StringBuilder newText = new StringBuilder();

        int strength = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == '>') {
                strength += text.charAt(i+1) - '0';
            }
            if (currentChar != '>' && strength > 0) {
                strength--;
                continue;
            }
            newText.append(currentChar);
        }
        System.out.println(newText);
    }
}
