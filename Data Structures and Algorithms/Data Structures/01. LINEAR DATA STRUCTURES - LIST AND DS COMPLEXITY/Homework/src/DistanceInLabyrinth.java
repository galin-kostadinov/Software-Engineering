import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DistanceInLabyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(reader.readLine());

        String[][] lab = new String[matrixSize][matrixSize];
        boolean[][] visited = new boolean[matrixSize][matrixSize];

        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = reader.readLine();
            for (int col = 0; col < matrixSize; col++) {
                char currentChar = line.charAt(col);
                lab[row][col] = currentChar + "";

                if (currentChar == '*') {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int row = startRow;
        int col = startCol;

        ArrayDeque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(row, col, true, 0));


        while (queue.size() != 0) {
            Cell current = queue.poll();

            row = current.getRow();
            col = current.getCol();

            visited[row][col] = true;

            if (!lab[row][col].equals("*")) {
                lab[row][col] = current.getMoves() + "";
            }

            if (row - 1 >= 0 && !lab[row - 1][col].equals("x") && !visited[row - 1][col]) {
                queue.offer(new Cell(row - 1, col, false, current.getMoves() + 1));
            }

            if (col + 1 < lab[row].length && !lab[row][col + 1].equals("x") && !visited[row][col + 1]) {
                queue.offer(new Cell(row, col + 1, false, current.getMoves() + 1));
            }

            if (row + 1 < lab.length && !lab[row + 1][col].equals("x") && !visited[row + 1][col]) {
                queue.offer(new Cell(row + 1, col, false, current.getMoves() + 1));
            }

            if (col - 1 >= 0 && !lab[row][col - 1].equals("x") && !visited[row][col - 1]) {
                queue.offer(new Cell(row, col - 1, false, current.getMoves() + 1));
            }
        }

        PrintLab(lab);
    }

    private static void PrintLab(String[][] lab) {
        int labSize = lab.length;
        for (int row = 0; row < labSize; row++) {
            for (int col = 0; col < labSize; col++) {
                if (lab[row][col].equals("0")) {
                    System.out.print("u");
                } else {
                    System.out.print(lab[row][col]);
                }
            }
            System.out.println();
        }
    }
}

class Cell {
    private int row;
    private int col;
    private boolean visited;
    private int moves;

    public Cell(int row, int col, boolean visited, int moves) {
        this.row = row;
        this.col = col;
        this.visited = visited;
        this.moves = moves;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
}
