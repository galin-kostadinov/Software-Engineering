import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sneaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            char[] currentRow = reader.readLine().toCharArray();
            matrix[row] = currentRow;
        }

        int[] samCoordinates = new int[2];

        int nikoladzeRow = 0;
        int nikoladzeCol = 0;

        List<Enemy> enemies = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];

                if (currChar == 'S') {
                    samCoordinates[0] = row;
                    samCoordinates[1] = col;
                } else if (currChar == 'N') {
                    nikoladzeRow = row;
                    nikoladzeCol = col;
                } else if (currChar == 'd' || currChar == 'b') {
                    Enemy enemy = new Enemy(currChar, row, col);
                    enemies.add(enemy);
                }
            }
        }

        ArrayDeque<Character> samMoves = new ArrayDeque<>();
        String moves = reader.readLine();

        for (int i = 0; i < moves.length(); i++) {
            samMoves.offer(moves.charAt(i));
        }

        while (!samMoves.isEmpty()) {
            updateEnemies(enemies, matrix);

            if (checkEnemies(matrix, enemies, samCoordinates)) {
                System.out.printf("Sam died at %d, %d%n", samCoordinates[0], samCoordinates[1]);
                matrix[samCoordinates[0]][samCoordinates[1]] = 'X';
                break;
            }

            char currentMove = samMoves.poll();
            moveSam(matrix, enemies, samCoordinates, currentMove);

            if (nikoladzeRow == samCoordinates[0]) {
                System.out.println("Nikoladze killed!");
                matrix[nikoladzeRow][nikoladzeCol] = 'X';
                break;
            }
        }

        printMatrix(matrix, rows);
    }

    private static void updateEnemies(List<Enemy> enemies, char[][] matrix) {
        for (Enemy enemy : enemies) {
            if (enemy.name == 'b') {
                if (enemy.col + 1 < matrix[enemy.row].length) {
                    matrix[enemy.row][enemy.col] = '.';
                    matrix[enemy.row][++enemy.col] = 'b';
                } else {
                    enemy.name = 'd';
                    matrix[enemy.row][enemy.col] = 'd';
                }
            } else if (enemy.name == 'd') {
                if (enemy.col - 1 >= 0) {
                    matrix[enemy.row][enemy.col] = '.';
                    matrix[enemy.row][--enemy.col] = 'd';
                } else {
                    enemy.name = 'b';
                    matrix[enemy.row][enemy.col] = 'b';
                }
            }
        }
    }

    private static void moveSam(char[][] matrix, List<Enemy> enemies, int[] samCoordinates, char currentMove) {
        switch (currentMove) {
            case 'U':
                matrix[samCoordinates[0]--][samCoordinates[1]] = '.';
                matrix[samCoordinates[0]][samCoordinates[1]] = 'S';
                break;
            case 'D':
                matrix[samCoordinates[0]++][samCoordinates[1]] = '.';
                matrix[samCoordinates[0]][samCoordinates[1]] = 'S';
                break;
            case 'L':
                matrix[samCoordinates[0]][samCoordinates[1]--] = '.';
                matrix[samCoordinates[0]][samCoordinates[1]] = 'S';
                break;
            case 'R':
                matrix[samCoordinates[0]][samCoordinates[1]++] = '.';
                matrix[samCoordinates[0]][samCoordinates[1]] = 'S';
                break;
            default:
                break;
        }

        removeEnemies(enemies, samCoordinates);
    }

    private static void removeEnemies(List<Enemy> enemies, int[] samCoordinates) {
        boolean hasEnemyToRemove = false;
        int currentIndex = 0;
        for (Enemy enemy : enemies) {
            if (enemy.row == samCoordinates[0] && enemy.col == samCoordinates[1]) {
                hasEnemyToRemove = true;
                break;
            }
            currentIndex++;
        }

        if (hasEnemyToRemove) {
            enemies.remove(currentIndex);
        }
    }

    private static boolean checkEnemies(char[][] matrix, List<Enemy> enemies, int[] samCoordinates) {
        for (Enemy enemy : enemies) {
            if (enemy.row == samCoordinates[0]) {
                if (enemy.name == 'b' && samCoordinates[1] > enemy.col) {
                    return true;
                } else if (enemy.name == 'd' && samCoordinates[1] < enemy.col) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void printMatrix(char[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    static class Enemy {
        char name;
        int row;
        int col;

        Enemy(char name, int row, int col) {
            this.name = name;
            this.row = row;
            this.col = col;
        }
    }
}
