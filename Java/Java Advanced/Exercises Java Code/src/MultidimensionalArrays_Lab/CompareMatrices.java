package MultidimensionsalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensionsFirst = readNumArr(sc.nextLine());
        int[][] firstMatrix = new int[dimensionsFirst[0]][dimensionsFirst[1]];

        for (int row = 0; row < dimensionsFirst[0]; row++) {
            int[] inputNumbers = readNumArr(sc.nextLine());
            for (int col = 0; col < dimensionsFirst[1]; col++) {
                firstMatrix[row][col] = inputNumbers[col];
            }
        }

        int[] dimensionsSecond = readNumArr(sc.nextLine());
        int[][] secondMatrix = new int[dimensionsSecond[0]][dimensionsSecond[1]];

        for (int row = 0; row < dimensionsSecond[0]; row++) {
            int[] inputNumbers = readNumArr(sc.nextLine());
            for (int col = 0; col < dimensionsSecond[1]; col++) {
                secondMatrix[row][col] = inputNumbers[col];
            }
        }

        if (dimensionsFirst[0] != dimensionsSecond[0] || dimensionsFirst[1] != dimensionsSecond[1]) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < dimensionsFirst[0]; row++) {
            for (int col = 0; col < dimensionsFirst[1]; col++) {
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
