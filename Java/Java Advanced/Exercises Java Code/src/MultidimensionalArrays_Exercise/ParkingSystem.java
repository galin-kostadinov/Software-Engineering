package MultidimensionalArrays_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimension = reader.readLine().split("\\s++");
        int row = Integer.parseInt(dimension[0]);
        int col = Integer.parseInt(dimension[1]);

        int[][] parking = new int[row][col];

        String input;

        while (!"stop".equals(input = reader.readLine())) {
            int[] token = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = token[0];
            int desiredRow = token[1];
            int desiredCol = token[2];

            if (parking[desiredRow][desiredCol] == 0) {
                parking[desiredRow][desiredCol] = 1;

                int distance = Math.abs(desiredRow - entryRow) + desiredCol + 1;

                System.out.println(distance);
            } else {
                boolean isParked = false;
                int index = 1;

                while (true) {
                    int leftCol = desiredCol - index;
                    int rightCol = desiredCol + index;

                    if (leftCol <= 0 && rightCol >= col) {
                        break;
                    }

                    if (leftCol > 0 && parking[desiredRow][leftCol] == 0) {
                        parking[desiredRow][leftCol] = 1;
                        int distance = Math.abs(desiredRow - entryRow) + leftCol + 1;
                        System.out.println(distance);
                        isParked = true;
                        break;
                    } else if (rightCol < col && parking[desiredRow][rightCol] == 0) {
                        parking[desiredRow][rightCol] = 1;
                        int distance = Math.abs(desiredRow - entryRow) + rightCol + 1;
                        System.out.println(distance);
                        isParked = true;
                        break;
                    }

                    index++;
                }

                if (!isParked) {
                    System.out.printf("Row %d full%n", desiredRow);
                }
            }
        }
    }
}
