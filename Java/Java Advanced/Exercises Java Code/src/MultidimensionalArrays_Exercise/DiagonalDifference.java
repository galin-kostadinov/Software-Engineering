package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dimension = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[dimension][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int firstDiagonalSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            firstDiagonalSum += matrix[row][row];
        }

        int secondDiagonalSum = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            secondDiagonalSum += matrix[row][matrix.length - 1 - row];
        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
