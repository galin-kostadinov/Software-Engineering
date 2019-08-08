package SetsAndMapsAdvanced_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Map<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            symbolsCount.putIfAbsent(symbol, 0);
            symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
        }

        symbolsCount.forEach((symbol, count) -> System.out.printf("%c: %d time/s%n", symbol, count));
    }
}
