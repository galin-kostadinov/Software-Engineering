package TextProcessingAndRegexExersice;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        int sum = 0;
        int maxLength = Math.max(words[0].length(), words[1].length());

        for (int i = 0; i < maxLength; i++) {
            if (words[0].length() > i && words[1].length() > i) {
                sum += words[0].charAt(i) * words[1].charAt(i);
            } else if (words[0].length() > i) {
                sum += words[0].charAt(i);
            } else if (words[1].length() > i) {
                sum += words[1].charAt(i);
            }
        }
        System.out.println(sum);
    }

}
