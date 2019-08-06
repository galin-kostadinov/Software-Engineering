package MultidimensionalArrays_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        ArrayList<ArrayList<Integer>> matrix = generateMatrix(rows, cols);

        String input;
        while (!"Nuke it from orbit".equals(input = sc.nextLine())) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rowIndex = tokens[0];
            int colIndex = tokens[1];
            int radius = tokens[2];

            for (int r = rowIndex - radius; r <= rowIndex + radius; r++) {
                if ((isInBound(matrix, r, colIndex))) {
                    matrix.get(r).set(colIndex, 0);
                }
            }

            for (int c = colIndex - radius; c <= colIndex + radius; c++) {
                if ((isInBound(matrix, rowIndex, c))) {
                    matrix.get(rowIndex).set(c, 0);
                }
            }

            for (int r = 0; r < matrix.size(); r++) {
                matrix.get(r).removeAll(new ArrayList<>(Arrays.asList(0)));

//              matrix.set(r, matrix.get(r)
//                        .stream()
//                        .filter(el -> el != 0)
//                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(r).size() == 0) {
                    matrix.remove(r);
                    r--;
                }
            }
        }

        printMatrix(matrix);
    }

    private static boolean isInBound(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0
                && row < matrix.size()
                && col >= 0
                && col < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> generateMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int value = 1;
        for (int r = 0; r < rows; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                row.add(value++);
            }
            matrix.add(row);
        }

        return matrix;
    }
}
