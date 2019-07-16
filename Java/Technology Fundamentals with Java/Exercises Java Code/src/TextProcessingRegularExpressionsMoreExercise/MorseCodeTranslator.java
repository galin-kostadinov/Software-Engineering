package TextProcessingRegularExpressionsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] morseWords = sc.nextLine().split("\\|");

        String regexLetter = "([.-]+){1}";
        Pattern pattern = Pattern.compile(regexLetter);

        List<String> english = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?"));

        List<String> morse = new ArrayList<>(Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."));

        List<String> englishWords = new ArrayList<>();
        for (int i = 0; i < morseWords.length; i++) {
            Matcher matcher = pattern.matcher(morseWords[i]);
            String currentWord = "";
            while (matcher.find()) {
                int indexOfLetter = morse.indexOf(matcher.group());
                if (indexOfLetter >= 0) {
                    currentWord += english.get(indexOfLetter);
                }
            }
            englishWords.add(currentWord);
        }
        englishWords.forEach(e -> System.out.printf("%s ", e.toUpperCase()));
        System.out.println();
    }
}
