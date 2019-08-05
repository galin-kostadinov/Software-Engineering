package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrixPrime = new int[rows][];

        for (int row = 0; row < matrixPrime.length; row++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrixPrime[row] = arr;
        }

        int[] wrongValueIndex = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrixPrime[wrongValueIndex[0]][wrongValueIndex[1]];

        int[][] outputMatrix = new int[rows][matrixPrime[rows - 1].length];


        for (int row = 0; row < matrixPrime.length; row++) {

            for (int col = 0; col < matrixPrime[row].length; col++) {
                if (matrixPrime[row][col] == wrongValue) {
                    outputMatrix[row][col] = calculatedValue(matrixPrime, wrongValue, row, col);
                } else {
                    outputMatrix[row][col] = matrixPrime[row][col];
                }
            }
        }

        printMatrix(outputMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int calculatedValue(int[][] matrixPrime, int wrongValue, int row, int col) {
        int upNumber;
        if (row - 1 < 0) {
            upNumber = 0;
        } else {
            upNumber = matrixPrime[row - 1][col];
        }

        int downNumber;
        if (row + 1 > matrixPrime.length - 1) {
            downNumber = 0;
        } else {
            downNumber = matrixPrime[row + 1][col];
        }

        int leftNumber;
        if (col - 1 < 0) {
            leftNumber = 0;
        } else {
            leftNumber = matrixPrime[row][col - 1];
        }

        int rightNumber;
        if (col + 1 > matrixPrime[row].length - 1) {
            rightNumber = 0;
        } else {
            rightNumber = matrixPrime[row][col + 1];
        }

        int sum = 0;

        if (upNumber != wrongValue) {
            sum += upNumber;
        }
        if (downNumber != wrongValue) {
            sum += downNumber;
        }
        if (leftNumber != wrongValue) {
            sum += leftNumber;
        }
        if (rightNumber != wrongValue) {
            sum += rightNumber;
        }
        return sum;

    }
}
