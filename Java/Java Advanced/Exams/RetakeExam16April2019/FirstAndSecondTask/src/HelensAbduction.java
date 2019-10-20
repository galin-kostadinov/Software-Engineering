import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelensAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int energy = Integer.parseInt(reader.readLine());
        int rows = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        int[] helenCoordinates = new int[2];
        int[] parisCoordinates = new int[2];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'H') {
                    helenCoordinates[0] = row;
                    helenCoordinates[1] = col;
                } else if (matrix[row][col] == 'P') {
                    parisCoordinates[0] = row;
                    parisCoordinates[1] = col;
                }
            }
        }

        boolean parisIsDied = false;

        while (!parisIsDied) {
            String[] token = reader.readLine().split("\\s++");

            String parisMove = token[0];

            int spartanRow = Integer.parseInt(token[1]);
            int spartanCol = Integer.parseInt(token[2]);

            if (parisCoordinates[0] == spartanRow && parisCoordinates[1] == spartanCol) {
                energy -= 2;

                if (energy <= 0) {
                    parisIsDied = true;
                    matrix[spartanRow][spartanCol] = 'X';
                    break;
                }
            } else {
                matrix[spartanRow][spartanCol] = 'S';
            }

            energy--;
            matrix[parisCoordinates[0]][parisCoordinates[1]] = '-';
            switch (parisMove) {
                case "up":
                    if (parisCoordinates[0] - 1 >= 0) {
                        --parisCoordinates[0];
                    }
                    break;
                case "down":
                    if (parisCoordinates[0] + 1 < matrix.length) {
                        ++parisCoordinates[0];
                    }
                    break;
                case "left":
                    if (parisCoordinates[1] - 1 >= 0) {
                        --parisCoordinates[1];
                    }
                    break;
                case "right":
                    if (parisCoordinates[1] + 1 < matrix[0].length) {
                        ++parisCoordinates[1];
                    }
                    break;
                default:
                    break;
            }

            if (matrix[parisCoordinates[0]][parisCoordinates[1]] == 'H') {
                matrix[helenCoordinates[0]][helenCoordinates[1]] = '-';
                break;
            } else if (matrix[parisCoordinates[0]][parisCoordinates[1]] == 'S') {
                energy -= 2;

                if (energy <= 0) {
                    parisIsDied = true;
                    matrix[parisCoordinates[0]][parisCoordinates[1]] = 'X';
                    break;
                } else {
                    matrix[parisCoordinates[0]][parisCoordinates[1]] = 'P';
                }
            } else if (energy <= 0) {
                parisIsDied = true;
                matrix[parisCoordinates[0]][parisCoordinates[1]] = 'X';
                break;
            } else {
                matrix[parisCoordinates[0]][parisCoordinates[1]] = 'P';
            }
        }

        if (parisIsDied) {
            System.out.printf("Paris died at %d;%d.%n", parisCoordinates[0], parisCoordinates[1]);
            print(matrix);
        } else {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
            print(matrix);
        }
    }

    private static void print(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
