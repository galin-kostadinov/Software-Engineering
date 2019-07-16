package TextProcessingAndRegexExersice;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        StringBuilder newText = new StringBuilder();
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (i > 0) {
                if (newText.charAt(index) != currentSymbol) {
                    newText.append(currentSymbol);
                    index++;
                }

            } else {
                newText.append(currentSymbol);
            }
        }
        System.out.println(newText);
    }
}
