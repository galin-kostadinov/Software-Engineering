package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(",\\s+".trim())).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrixPrime = new int[rows][cols];

        for (int row = 0; row < matrixPrime.length; row++) {
            int[] nums = Arrays.stream(sc.nextLine().split(",\\s+".trim())).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrixPrime[row].length; col++) {
                matrixPrime[row][col] = nums[col];
            }
        }

        int[][] subMatrix = new int[2][2];
        int sumSubMatrix = 0;

        int startIndexRow = 0;
        int startIndexCol = 0;

        while ((matrixPrime.length - startIndexRow) >= 2) {
            int[][] currentMatrix = new int[2][2];
            int indexRowSub = 0;
            int indexColSub = 0;
            int sum = 0;

            for (int row = startIndexRow; row < startIndexRow + 2; row++) {
                for (int col = startIndexCol; col < startIndexCol + 2; col++) {
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

            if (matrixPrime[rows - 1].length - startIndexCol < 2) {
                startIndexCol = 0;
                startIndexRow++;
            }
        }

        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.printf("%d ", subMatrix[row][col]);
            }
            System.out.println();
        }
        System.out.println(sumSubMatrix);
    }

//    private static int getMatrixSum(int[][] matrix) {
//        int sum = 0;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                sum += matrix[row][col];
//            }
//        }
//
//        return sum;
//    }
}
