package MultidimensionalArrays_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimension = reader.readLine().split("\\s++");
        int rowMatrix = Integer.parseInt(dimension[0]);
        int colMatrix = Integer.parseInt(dimension[1]);

        char[][] matrix = new char[rowMatrix][colMatrix];

        for (int r = 0; r < rowMatrix; r++) {
            String line = reader.readLine().trim().replace(" ", "");
            char[] currentRow = line.toCharArray();
            matrix[r] = currentRow;
        }

        char fillChar = reader.readLine().charAt(0);

        String[] start = reader.readLine().split("\\s++");

        int startRow = Integer.parseInt(start[0]);
        int startCol = Integer.parseInt(start[1]);
        char startChar = matrix[startRow][startCol];

        boolean[][] visited = new boolean[rowMatrix][colMatrix];

        int row = startRow;
        int col = startCol;

        ArrayDeque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(row, col));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            row = current.getRow();
            col = current.getCol();

            visited[row][col] = true;

            if (matrix[row][col] == startChar) {
                matrix[row][col] = fillChar;
            }

            if (row - 1 >= 0 && matrix[row - 1][col] == startChar && !visited[row - 1][col]) {
                queue.offer(new Cell(row - 1, col));
            }

            if (col + 1 < matrix[row].length && matrix[row][col + 1] == startChar && !visited[row][col + 1]) {
                queue.offer(new Cell(row, col + 1));
            }

            if (row + 1 < matrix.length && matrix[row + 1][col] == startChar && !visited[row + 1][col]) {
                queue.offer(new Cell(row + 1, col));
            }

            if (col - 1 >= 0 && matrix[row][col - 1] == startChar && !visited[row][col - 1]) {
                queue.offer(new Cell(row, col - 1));
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        int matrixSizeRow = matrix.length;
        int matrixSizeCol = matrix[0].length;

        for (int row = 0; row < matrixSizeRow; row++) {
            for (int col = 0; col < matrixSizeCol; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

class Cell {
    private int row;
    private int col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
