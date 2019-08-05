package MultidimensionalArrays_Lab;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[][] matrix = new String[N][N];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = sc.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col];
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            System.out.printf("%s ", matrix[row][row]);
        }
        System.out.println();

        for (int row = matrix.length - 1; row >= 0; row--) {
            System.out.printf("%s ", matrix[row][matrix.length - 1 - row]);
        }
        System.out.println();
    }
}
