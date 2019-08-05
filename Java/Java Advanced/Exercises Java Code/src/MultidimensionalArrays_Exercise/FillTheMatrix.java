package MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(",\\s+");
        int dimensions = Integer.parseInt(tokens[0]);
        String type = tokens[1];

        int[][] matrix = new int[dimensions][dimensions];

        int counter = 1;
        if (type.equals("A")) {
            for (int col = 0; col < dimensions; col++) {
                for (int row = 0; row < dimensions; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        } else if (type.equals("B")) {
            for (int col = 0; col < dimensions; col++) {
                if (col % 2 != 0) {
                    for (int row = dimensions - 1; row >= 0; row--) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                } else {
                    for (int row = 0; row < dimensions; row++) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
