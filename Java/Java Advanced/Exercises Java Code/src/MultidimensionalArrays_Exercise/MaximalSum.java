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

        int subMatrixSize = 3;
        int sumSubMatrix = 0;
        int startIndexRow = 0;
        int startIndexCol = 0;
        int startIndexRowSubMatrix = 0;
        int startIndexColSubMatrix = 0;

        while ((matrixPrime.length - startIndexRow) >= subMatrixSize) {
            int sum = 0;

            for (int row = startIndexRow; row < startIndexRow + subMatrixSize; row++) {
                for (int col = startIndexCol; col < startIndexCol + subMatrixSize; col++) {
                    sum += matrixPrime[row][col];
                }
            }

            if (sum > sumSubMatrix) {
                sumSubMatrix = sum;
                startIndexRowSubMatrix = startIndexRow;
                startIndexColSubMatrix = startIndexCol;
            }

            startIndexCol++;

            if (matrixPrime[rows - 1].length - startIndexCol < subMatrixSize) {
                startIndexCol = 0;
                startIndexRow++;
            }
        }

        int[][] subMatrix = createSubMatrix(matrixPrime, startIndexRowSubMatrix, startIndexColSubMatrix, subMatrixSize);

        System.out.println("Sum = " + sumSubMatrix);

        printMatrix(subMatrix);
    }

    private static void printMatrix(int[][] subMatrix) {
        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.printf("%d ", subMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[][] createSubMatrix(int[][] matrixPrime, int startIndexRowSubMatrix, int startIndexColSubMatrix,
                                           int subMatrixSize) {
        int[][] subMatrix = new int[subMatrixSize][subMatrixSize];

        int indexRowSub = 0;
        int indexColSub = 0;
        for (int row = startIndexRowSubMatrix; row < startIndexRowSubMatrix + subMatrixSize; row++) {
            for (int col = startIndexColSubMatrix; col < startIndexColSubMatrix + subMatrixSize; col++) {
                subMatrix[indexRowSub][indexColSub] = matrixPrime[row][col];
                indexColSub++;
            }

            indexRowSub++;
            indexColSub = 0;
        }
        return subMatrix;
    }
}
