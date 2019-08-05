package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(",\\s+".trim())).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] nums = Arrays.stream(sc.nextLine().split(",\\s+".trim())).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = nums[col];
                sum += matrix[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
