package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> players = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+".trim())).forEach(players::offer);

        int counter = Integer.parseInt(sc.nextLine());

        while (players.size() > 1) {

            for (int i = 0; i < counter - 1; i++) {
                String currentPlayer = players.poll();
                players.offer(currentPlayer);
            }

            System.out.printf("Removed %s%n", players.poll());
        }

        System.out.printf("Last is %s%n", players.poll());
    }
}
