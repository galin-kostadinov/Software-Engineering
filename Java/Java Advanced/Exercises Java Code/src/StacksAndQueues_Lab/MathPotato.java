package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> players = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+".trim())).forEach(players::offer);

        int counter = Integer.parseInt(sc.nextLine());

        int cycle = 1;
        while (players.size() > 1) {

            for (int i = 0; i < counter - 1; i++) {
                String currentPlayer = players.poll();
                players.offer(currentPlayer);
            }

            if (isPrimeCycle(cycle)) {
                System.out.printf("Prime %s%n", players.peek());
            } else {
                System.out.printf("Removed %s%n", players.poll());
            }

            cycle++;
        }

        System.out.printf("Last is %s%n", players.poll());
    }

    private static boolean isPrimeCycle(int cycle) {
        boolean isPrime = true;
        if (cycle == 1) {
            return isPrime = false;
        }
        for (int i = 2; i <= Math.sqrt(cycle); i++) {
            if (cycle % i == 0) {
                isPrime = false;
            }
        }

        return isPrime;
    }
}

