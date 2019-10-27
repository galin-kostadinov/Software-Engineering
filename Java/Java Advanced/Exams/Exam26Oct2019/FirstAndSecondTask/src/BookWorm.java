import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookWorm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String initialString = reader.readLine();
        int size = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[size][];

        for (int row = 0; row < size; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }

        int playerRow = -1;
        int playerCol = -1;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (matrix[r][c] == 'P') {
                    playerRow = r;
                    playerCol = c;
                    break;
                }
            }

            if (playerRow != -1) {
                break;
            }
        }

        String command;
        while (!"end".equals(command = reader.readLine())) {
            boolean isPunished = false;
            int playerRowOld = playerRow;
            int playerColOld = playerCol;
            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        playerRow--;
                    } else {
                        isPunished = true;
                    }
                    break;
                case "down":
                    if (playerRow + 1 < size) {
                        playerRow++;
                    } else {
                        isPunished = true;
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        playerCol--;
                    } else {
                        isPunished = true;
                    }
                    break;
                case "right":
                    if (playerCol + 1 < size) {
                        playerCol++;
                    } else {
                        isPunished = true;
                    }
                    break;
                default:
                    break;

            }

            if (isPunished) {
                if (!initialString.isEmpty()) {
                    initialString = initialString.substring(0, initialString.length() - 1);
                }
            } else {
                if (matrix[playerRow][playerCol] != '-') {
                    initialString += matrix[playerRow][playerCol];
                }
                matrix[playerRowOld][playerColOld] = '-';

                matrix[playerRow][playerCol] = 'P';
            }
        }

        System.out.println(initialString);

        printMatrix(matrix);
    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
