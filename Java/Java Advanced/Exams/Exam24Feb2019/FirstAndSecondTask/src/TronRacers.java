import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[matrixSize][];

        for (int row = 0; row < matrixSize; row++) {
            char[] currentRow = reader.readLine().toCharArray();
            matrix[row] = currentRow;
        }

        int[] fCoordinates = new int[2];
        int[] sCoordinates = new int[2];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[row][col] == 'f') {
                    fCoordinates[0] = row;
                    fCoordinates[1] = col;
                } else if (matrix[row][col] == 's') {
                    sCoordinates[0] = row;
                    sCoordinates[1] = col;
                }
            }
        }

        String[] token = reader.readLine().split("\\s++");

        while (true) {
            String fMove = token[0];
            String sMove = token[1];

            if (!executeCommand(matrix, fCoordinates, fMove)) {
                break;
            }

            if (!executeCommand(matrix, sCoordinates, sMove)) {
                break;
            }

            token = reader.readLine().split("\\s++");
        }

        print(matrix, matrixSize);
    }

    private static void print(char[][] matrix, int matrixSize) {
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean executeCommand(char[][] matrix, int[] playerCoordinates, String playerMove) {
        int row = playerCoordinates[0];
        int col = playerCoordinates[1];
        switch (playerMove) {
            case "up":
                row--;
                if (row < 0) {
                    row = matrix.length - 1;
                }
                break;
            case "down":
                row++;
                if (row > matrix.length - 1) {
                    row = 0;
                }
                break;
            case "left":
                col--;
                if (col < 0) {
                    col = matrix[0].length - 1;
                }
                break;
            case "right":
                col++;
                if (col > matrix[0].length - 1) {
                    col = 0;
                }
                break;
            default:
                break;
        }

        if (matrix[row][col] != '*') {
            matrix[row][col] = 'x';
            return false;
        } else {
            matrix[row][col] = matrix[playerCoordinates[0]][playerCoordinates[1]];
            playerCoordinates[0] = row;
            playerCoordinates[1] = col;
            return true;
        }
    }
}
