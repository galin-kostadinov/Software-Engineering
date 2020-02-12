package queenspuzzle;

import java.util.HashSet;
import java.util.Set;

public class QueensPuzzle {
    private static final int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];

    private static Set<Integer> attackedRows = new HashSet<>();
    private static Set<Integer> attackedCols = new HashSet<>();

    static void solve(int row) {
        if (row == SIZE) {
            printSolution();
        } else {
            for (int col = 0; col < SIZE; col++) {
                if (canPlaceQueen(row, col)) {
                    markAttackedField(row, col);
                    solve(row + 1);
                    unmarkAttackedFields(row, col);
                }
            }
        }
    }

    private static void printSolution() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    private static void unmarkAttackedFields(int row, int col) {
        board[row][col] = 0;
        attackedRows.remove(row);
        attackedCols.remove(col);
    }

    private static void markAttackedField(int row, int col) {
        board[row][col] = 1;
        attackedRows.add(row);
        attackedCols.add(col);
    }

    private static boolean canPlaceQueen(int row, int col) {
        if (attackedRows.contains(row)) {
            return false;
        }

        if (attackedCols.contains(col)) {
            return false;
        }

        //left-up
        for (int i = 1; i < SIZE; i++) {
            int currRow = row - i;
            int currCol = col - i;

            if (currRow < 0 || currRow >= SIZE || currCol < 0 || currCol >= SIZE) {
                break;
            }

            if (board[currRow][currCol] == 1) {
                return false;
            }
        }

        //right-up
        for (int i = 1; i < SIZE; i++) {
            int currRow = row - i;
            int currCol = col + i;

            if (currRow < 0 || currRow >= SIZE || currCol < 0 || currCol >= SIZE) {
                break;
            }

            if (board[currRow][currCol] == 1) {
                return false;
            }
        }

        //left-down
        for (int i = 1; i < SIZE; i++) {
            int currRow = row + i;
            int currCol = col - i;

            if (currRow < 0 || currRow >= SIZE || currCol < 0 || currCol >= SIZE) {
                break;
            }

            if (board[currRow][currCol] == 1) {
                return false;
            }
        }

        //right-down
        for (int i = 1; i < SIZE; i++) {
            int currRow = row + i;
            int currCol = col + i;

            if (currRow < 0 || currRow >= SIZE || currCol < 0 || currCol >= SIZE) {
                break;
            }

            if (board[currRow][currCol] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        solve(0);
    }
}
