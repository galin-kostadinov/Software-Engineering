package SetsAndMapsAdvanced_Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, HashSet<String>> player = new LinkedHashMap<>();

        String input;

        while (!"JOKER".equals(input = sc.nextLine())) {
            String name = input.substring(0, input.indexOf(":"));

            String[] cards = input.substring(input.indexOf(":") + 2).split(",\\s+");

            player.putIfAbsent(name, new HashSet<>());
            player.get(name).addAll(Arrays.asList(cards));
        }

        for (Map.Entry<String, HashSet<String>> kvp : player.entrySet()) {
            String playerName = kvp.getKey();

            int deckPower = calculateDeckPower(kvp.getValue());

            System.out.println(String.format("%s: %d", playerName, deckPower));
        }
    }

    private static int calculateDeckPower(HashSet<String> cards) {
        int power = 0;
        for (String card : cards) {
            int cardValue = 0;
            if (Character.isDigit(card.charAt(0))) {
                cardValue = Integer.parseInt(card.substring(0, card.length() - 1));
            } else if (card.charAt(0) == 'J') {
                cardValue = 11;
            } else if (card.charAt(0) == 'Q') {
                cardValue = 12;
            } else if (card.charAt(0) == 'K') {
                cardValue = 13;
            } else if (card.charAt(0) == 'A') {
                cardValue = 14;
            }

            if (card.endsWith("S")) {
                cardValue *= 4;
            } else if (card.endsWith("H")) {
                cardValue *= 3;
            } else if (card.endsWith("D")) {
                cardValue *= 2;
            }
            power += cardValue;
        }

        return power;
    }
}
