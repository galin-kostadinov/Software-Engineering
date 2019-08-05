package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = readNumArr(sc.nextLine());
        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int row = 0; row < dimensions[0]; row++) {
            int[] inputNumbers = readNumArr(sc.nextLine());
            for (int col = 0; col < dimensions[1]; col++) {
                matrix[row][col] = inputNumbers[col];
            }
        }

        int searchingNumber = Integer.parseInt(sc.nextLine());
        boolean isFound = false;
        for (int row = 0; row < dimensions[0]; row++) {
            for (int col = 0; col < dimensions[1]; col++) {
                if (matrix[row][col] == searchingNumber) {
                    System.out.printf("%d %d%n", row, col);
                    isFound = true;
                }
            }
        }

        if (!isFound){
            System.out.println("not found");
        }
    }

    private static int[] readNumArr(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
