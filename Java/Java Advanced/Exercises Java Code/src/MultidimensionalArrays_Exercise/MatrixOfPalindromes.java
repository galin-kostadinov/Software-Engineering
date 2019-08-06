package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+".trim())).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] palindromesMatrix = new String[rows][cols];

        char row = 'a';
        for (int indexRow = 0; indexRow < palindromesMatrix.length; indexRow++) {
            char col = (char) ('a' + indexRow);

            for (int indexCol = 0; indexCol < palindromesMatrix[rows - 1].length; indexCol++) {
                palindromesMatrix[indexRow][indexCol] = String.format("%c%c%c", row, col, row);
                col++;
            }

            row++;
        }

        printMatrix(palindromesMatrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
