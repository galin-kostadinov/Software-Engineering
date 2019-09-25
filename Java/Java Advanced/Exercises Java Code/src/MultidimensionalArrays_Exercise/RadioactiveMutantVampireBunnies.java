package MultidimensionalArrays_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lairDimensions = reader.readLine().split("\\s++");
        int rowLair = Integer.parseInt(lairDimensions[0]);
        int colLair = Integer.parseInt(lairDimensions[1]);

        int rowPlayer = 0;
        int colPlayer = 0;

        char[][] lair = new char[rowLair][];

        ArrayDeque<Integer[]> queueBunnies = new ArrayDeque<>();

        for (int row = 0; row < rowLair; row++) {
            String line = reader.readLine();

            char[] currentLairRow = new char[colLair];

            for (int col = 0; col < colLair; col++) {
                currentLairRow[col] = line.charAt(col);
                if (line.charAt(col) == 'P') {
                    rowPlayer = row;
                    colPlayer = col;
                }
            }

            lair[row] = currentLairRow;
        }

        String playerMoves = reader.readLine();

        int lastRowPlayer = 0;
        int lastColPlayer = 0;

        boolean isDead = false;
        boolean isOut = false;

        for (int i = 0; i < playerMoves.length(); i++) {
            char currentMove = playerMoves.charAt(i);

            lastRowPlayer = rowPlayer;
            lastColPlayer = colPlayer;

            if (currentMove == 'R') {
                ++colPlayer;
            } else if (currentMove == 'L') {
                --colPlayer;
            } else if (currentMove == 'U') {
                --rowPlayer;
            } else if (currentMove == 'D') {
                ++rowPlayer;
            }

            isOut = colPlayer >= colLair ||
                    colPlayer < 0 ||
                    rowPlayer >= rowLair ||
                    rowPlayer < 0;

            if (isOut) {
                lair[lastRowPlayer][lastColPlayer] = '.';
            } else {
                lair[lastRowPlayer][lastColPlayer] = '.';

                if (lair[rowPlayer][colPlayer] == '.') {
                    lair[rowPlayer][colPlayer] = 'P';
                } else if (lair[rowPlayer][colPlayer] == 'B') {
                    isDead = true;
                    lastRowPlayer = rowPlayer;
                    lastColPlayer = colPlayer;
                }
            }

            offerQueueBunnies(queueBunnies, lair, rowLair, colLair);

            while (!queueBunnies.isEmpty()) {
                Integer[] currBunny = queueBunnies.poll();

                int up = currBunny[0] - 1;
                int down = currBunny[0] + 1;
                int left = currBunny[1] - 1;
                int right = currBunny[1] + 1;

                if (!isDead) {
                    isDead = isDead(currBunny, rowPlayer, colPlayer, up, down, left, right);

                    if (isDead) {
                        lastRowPlayer = rowPlayer;
                        lastColPlayer = colPlayer;
                    }
                }

                spreadBunnies(lair, currBunny, up, down, left, right);
            }

            if (isDead || isOut) {
                break;
            }
        }

        printLair(lair);

        if (isDead) {
            System.out.printf("dead: %d %d%n", lastRowPlayer, lastColPlayer);
        }

        if (isOut) {
            System.out.printf("won: %d %d%n", lastRowPlayer, lastColPlayer);
        }
    }

    private static void printLair(char[][] lair) {
        StringBuilder text = new StringBuilder();
        int rowLair = lair.length;
        int colLair = lair[0].length;

        for (int row = 0; row < rowLair; row++) {
            for (int col = 0; col < colLair; col++) {
                text.append(lair[row][col]);
            }
            text.append(System.lineSeparator());
        }

        System.out.print(text.toString());
    }

    private static boolean isDead(Integer[] currBunny, int rowPlayer, int colPlayer, int up, int down, int left, int right) {
        return (rowPlayer == currBunny[0] && colPlayer == left) ||
                (rowPlayer == currBunny[0] && colPlayer == right) ||
                (colPlayer == currBunny[1] && rowPlayer == up) ||
                (colPlayer == currBunny[1] && rowPlayer == down);
    }

    private static void spreadBunnies(char[][] lair, Integer[] currBunny, int up, int down, int left, int right) {
        int rowLair = lair.length;
        int colLair = lair[0].length;

        if (up >= 0) {
            lair[up][currBunny[1]] = 'B';
        }
        if (down < rowLair) {
            lair[down][currBunny[1]] = 'B';
        }
        if (left >= 0) {
            lair[currBunny[0]][left] = 'B';
        }
        if (right < colLair) {
            lair[currBunny[0]][right] = 'B';
        }
    }

    private static void offerQueueBunnies(ArrayDeque<Integer[]> queueBunnies, final char[][] lair, int rowLair, int colLair) {
        for (int row = 0; row < rowLair; row++) {
            for (int col = 0; col < colLair; col++) {
                char cell = lair[row][col];
                if (cell == 'B') {
                    Integer[] currBunny = {row, col};
                    queueBunnies.offer(currBunny);
                }
            }
        }
    }
}
