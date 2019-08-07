package SetsAndMapsAdvanced_Lab;

import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> firstPlayer = setPlayerCards(sc.nextLine());

        Set<Integer> secondPlayer = setPlayerCards(sc.nextLine());

        for (int round = 0; round < 50; round++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            Iterator<Integer> firstPlayerIterator = firstPlayer.iterator();
            Iterator<Integer> secondPlayerIterator = secondPlayer.iterator();

            int firstPlayerValue = firstPlayerIterator.next();
            int secondPlayerValue = secondPlayerIterator.next();

            if (firstPlayerValue > secondPlayerValue) {
                firstPlayer.add((firstPlayerValue));
                firstPlayer.add((secondPlayerValue));
            } else if (firstPlayerValue < secondPlayerValue) {
                secondPlayer.add(firstPlayerValue);
                secondPlayer.add(secondPlayerValue);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First Player Win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second Player Win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static LinkedHashSet<Integer> setPlayerCards(String nextLine) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Arrays.stream(nextLine.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(result::add);

        return result;
    }
}
