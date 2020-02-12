package paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindAllPathsInLabyrinth {

    private static char[][] labyrinth;
    private static boolean[][] visited;
    private static List<Character> path = new ArrayList<>();
    private static int rows;
    private static int cols;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rows = Integer.parseInt(br.readLine());
        cols = Integer.parseInt(br.readLine());

        initialReadLabyrinth(br);
        initialVisitedMatrix();

        solve(0, 0, ' ');
    }

    private static void initialVisitedMatrix() {
        visited = new boolean[rows][cols];
    }

    private static void solve(int row, int col, char direction) {
        if (!isInBound(row, col)) {
            return;
        }

        path.add(direction);

        if (isExit(row, col)) {
            printFoundedPath();
        } else if (!isVisited(row, col) && isPassable(row, col)) {
            mark(row, col);

            solve(row + 1, col, 'D');
            solve(row - 1, col, 'U');
            solve(row, col + 1, 'R');
            solve(row, col - 1, 'L');

            unmark(row, col);
        }

        path.remove(path.size() - 1);
    }

    private static boolean isExit(int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static void mark(int row, int col) {
        visited[row][col] = true;
    }

    private static boolean isVisited(int row, int col) {
        return visited[row][col];
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static void unmark(int row, int col) {
        visited[row][col] = false;
    }

    private static boolean isPassable(int row, int col) {
        return labyrinth[row][col] == '-';
    }

    private static void printFoundedPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.printf("%c", path.get(i));
        }

        System.out.println();
    }

    private static void initialReadLabyrinth(BufferedReader br) throws IOException {
        labyrinth = new char[rows][];

        for (int row = 0; row < rows; row++) {
            labyrinth[row] = br.readLine().toCharArray();
        }
    }
}
