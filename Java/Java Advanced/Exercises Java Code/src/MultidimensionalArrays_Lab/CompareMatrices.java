package MultidimensionalArrays_Lab;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensionFirst = readNumArr(sc.nextLine());
        int[][] firstMatrix = new int[dimensionFirst[0]][dimensionFirst[1]];

        for (int row = 0; row < dimensionFirst[0]; row++) {
            int[] inputNumbers = readNumArr(sc.nextLine());
            for (int col = 0; col < dimensionFirst[1]; col++) {
                firstMatrix[row][col] = inputNumbers[col];
            }
        }

        int[] dimensionSecond = readNumArr(sc.nextLine());
        int[][] secondMatrix = new int[dimensionSecond[0]][dimensionSecond[1]];

        for (int row = 0; row < dimensionSecond[0]; row++) {
            int[] inputNumbers = readNumArr(sc.nextLine());
            for (int col = 0; col < dimensionSecond[1]; col++) {
                secondMatrix[row][col] = inputNumbers[col];
            }
        }

        if (dimensionFirst[0] != dimensionSecond[0] || dimensionFirst[1] != dimensionSecond[1]) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < dimensionFirst[0]; row++) {
            for (int col = 0; col < dimensionFirst[1]; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }

    private static int[] readNumArr(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
