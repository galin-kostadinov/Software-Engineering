package TextProcessingRegularExpressionsMoreExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toUpperCase();
        String regexText = "(?<text>[^\\d]+)";
        String regexCount = "(?<count>\\d+)";
        Pattern patternText = Pattern.compile(regexText);
        Pattern patternCount = Pattern.compile(regexCount);

        StringBuilder output = new StringBuilder();
        Matcher matcherText = patternText.matcher(input);
        Matcher matcherCount = patternCount.matcher(input);


        while (matcherText.find() && matcherCount.find()) {
            String currentText = matcherText.group("text");
            int count = Integer.parseInt(matcherCount.group("count"));
            for (int i = 0; i < count; i++) {
                output.append(currentText);
            }

        }
        String textOutput = output.toString();
        List<Character> diffSymbols = new LinkedList<>();
        for (int i = 0; i < textOutput.length(); i++) {
            char currentSymbol = textOutput.charAt(i);
            if (!diffSymbols.contains(currentSymbol)) {
                diffSymbols.add(currentSymbol);
            }
        }
        int uniqueSymbolsCount = diffSymbols.size();

        System.out.printf("Unique symbols used: %d%n", uniqueSymbolsCount);
        System.out.println(textOutput);
    }
}
