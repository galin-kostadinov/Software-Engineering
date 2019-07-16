package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> firstPlayer = inputList(sc.nextLine());
        List<Integer> secondPlayer = inputList(sc.nextLine());

        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            int firstPlayercard = firstPlayer.get(0);
            int secondPlayerCard = secondPlayer.get(0);

            if (firstPlayercard > secondPlayerCard) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
                firstPlayer.add(firstPlayercard);
                firstPlayer.add(secondPlayerCard);
            } else if (firstPlayercard < secondPlayerCard) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
                secondPlayer.add(secondPlayerCard);
                secondPlayer.add(firstPlayercard);
            } else if (firstPlayercard == secondPlayerCard) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }

        }
        int firstPlayerSum = firstPlayer.stream().mapToInt(Integer::intValue).sum();
        int secondPlayerSum = secondPlayer.stream().mapToInt(Integer::intValue).sum();
        if (firstPlayerSum > secondPlayerSum) {
            System.out.printf("First player wins! Sum: %d%n", firstPlayerSum);
        } else if (firstPlayerSum < secondPlayerSum) {
            System.out.printf("Second player wins! Sum: %d%n", secondPlayerSum);
        }
    }

    private static List<Integer> inputList(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
