package MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+".trim())).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrixPrime = new int[rows][];

        for (int row = 0; row < matrixPrime.length; row++) {
            matrixPrime[row] = Arrays.stream(sc.nextLine().split("\\s+".trim())).mapToInt(Integer::parseInt).toArray();
        }

        int[][] subMatrix = new int[3][3];
        int sumSubMatrix = 0;

        int startIndexRow = 0;
        int startIndexCol = 0;

        while ((matrixPrime.length - startIndexRow) >= 3) {
            int[][] currentMatrix = new int[3][3];
            int indexRowSub = 0;
            int indexColSub = 0;
            int sum = 0;

            for (int row = startIndexRow; row < startIndexRow + 3; row++) {
                for (int col = startIndexCol; col < startIndexCol + 3; col++) {
                    currentMatrix[indexRowSub][indexColSub] = matrixPrime[row][col];
                    sum += currentMatrix[indexRowSub][indexColSub];
                    indexColSub++;
                }

                indexRowSub++;
                indexColSub = 0;
            }

            if (sum > sumSubMatrix) {
                sumSubMatrix = sum;
                subMatrix = currentMatrix;
            }

            startIndexCol++;

            if (matrixPrime[rows - 1].length - startIndexCol < 3) {
                startIndexCol = 0;
                startIndexRow++;
            }
        }

        System.out.println("Sum = " + sumSubMatrix);

        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.printf("%d ", subMatrix[row][col]);
            }
            System.out.println();
        }
    }
}
