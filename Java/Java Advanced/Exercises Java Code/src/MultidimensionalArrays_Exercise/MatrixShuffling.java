package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }

        String input;
        while (!"END".equalsIgnoreCase(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");

            if (validInput(tokens, rows, cols)) {
                String command = tokens[0];
                int firstRowIndex = Integer.parseInt(tokens[1]);
                int firstColIndex = Integer.parseInt(tokens[2]);
                int secondRowIndex = Integer.parseInt(tokens[3]);
                int secondColIndex = Integer.parseInt(tokens[4]);

                String firstElement = matrix[firstRowIndex][firstColIndex];
                String secondElement = matrix[secondRowIndex][secondColIndex];

                matrix[firstRowIndex][firstColIndex] = secondElement;
                matrix[secondRowIndex][secondColIndex] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean validInput(String[] tokens, int rows, int cols) {
        boolean isValid = true;
        if (tokens.length != 5) {
            return isValid = false;
        }

        if (!tokens[0].equals("swap")) {
            return isValid = false;
        }

        int firstRowIndex = Integer.parseInt(tokens[1]);
        int firstColIndex = Integer.parseInt(tokens[2]);
        int secondRowIndex = Integer.parseInt(tokens[3]);
        int secondColIndex = Integer.parseInt(tokens[4]);

        if (firstRowIndex < 0 || firstRowIndex > rows - 1) {
            isValid = false;
        }

        if (secondRowIndex < 0 || secondRowIndex > rows - 1) {
            isValid = false;
        }

        if (firstColIndex < 0 || firstColIndex > cols - 1) {
            isValid = false;
        }

        if (secondColIndex < 0 || secondColIndex > cols - 1) {
            isValid = false;
        }

        return isValid;
    }
}
