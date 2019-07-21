package DemoFinalExam21July2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSumator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        String regex = "(?<=(\\s|,|\\?|!|\\.))(?<emoji>:[a-z]{4,}:)(?=(\\s|,|\\?|!|\\.))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        List<String> validEmoji = new ArrayList<>();

        while (matcher.find()) {
            String currenEmoji = matcher.group("emoji");
            validEmoji.add(currenEmoji);
        }

        List<String> emojiCodes = new ArrayList<>();

        int totalSum = 0;
        for (int i = 0; i < validEmoji.size(); i++) {
            String currentEmoji = validEmoji.get(i);
            int emojiSum = 0;
            String emojiASCIICode = "";
            for (int j = 1; j < currentEmoji.length() - 1; j++) {
                char currentChar = currentEmoji.charAt(j);
                emojiSum += currentChar;
                if (j < currentEmoji.length() - 2) {
                    emojiASCIICode += (int) currentChar + ":";
                } else {
                    emojiASCIICode += (int) currentChar + "";
                }
            }
            emojiCodes.add(emojiASCIICode);
            totalSum += emojiSum;
        }

        String emojiCode = sc.nextLine();
        int multilayer = 1;
        for (int i = 0; i < emojiCodes.size(); i++) {
            if (emojiCodes.get(i).equals(emojiCode)) {
                multilayer *= 2;
            }
        }
        totalSum *= multilayer;
        if (validEmoji.size() > 0) {
            System.out.print("Emojis found: ");
            System.out.println(String.join(", ", validEmoji));
        }
        System.out.printf("Total Emoji Power: %d%n", totalSum);
    }
}
