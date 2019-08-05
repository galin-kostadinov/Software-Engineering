package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = sc.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = input[col].charAt(0);
            }
        }

        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = sc.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = input[col].charAt(0);
            }
        }

        char[][] thirdMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col]==(secondMatrix[row][col])) {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                } else {
                    thirdMatrix[row][col] = '*';
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%c ", thirdMatrix[row][col]);
            }
            System.out.println();
        }
    }
}
