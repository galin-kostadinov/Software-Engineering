import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpaceStationEstablishment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int neededStarsPower = 50;

        int size = Integer.parseInt(reader.readLine());

        char[][] galaxy = new char[size][];
        for (int row = 0; row < size; row++) {
            galaxy[row] = reader.readLine().toCharArray();
        }

        int[] playerCoordinates = new int[2];

        int[] firstBlackHoleCoordinates = {-1, -1};
        int[] secondBlackHoleCoordinates = {-1, -1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (galaxy[row][col] == 'S') {
                    playerCoordinates[0] = row;
                    playerCoordinates[1] = col;
                } else if (galaxy[row][col] == 'O') {
                    if (firstBlackHoleCoordinates[0] == -1) {
                        firstBlackHoleCoordinates[0] = row;
                        firstBlackHoleCoordinates[1] = col;
                    } else {
                        secondBlackHoleCoordinates[0] = row;
                        secondBlackHoleCoordinates[1] = col;
                    }
                }
            }
        }

        boolean outOfGalaxy = false;
        int starsPower = 0;

        while (starsPower < neededStarsPower) {
            String command = reader.readLine();

            galaxy[playerCoordinates[0]][playerCoordinates[1]] = '-';

            switch (command) {
                case "up":
                    if (--playerCoordinates[0] < 0) {
                        outOfGalaxy = true;
                    }
                    break;
                case "down":
                    if (++playerCoordinates[0] >= size) {
                        outOfGalaxy = true;
                    }
                    break;
                case "left":
                    if (--playerCoordinates[1] < 0) {
                        outOfGalaxy = true;
                    }
                    break;
                case "right":
                    if (++playerCoordinates[1] >= size) {
                        outOfGalaxy = true;
                    }
                    break;
                default:
                    break;
            }

            if (outOfGalaxy) {
                break;
            }

            if (playerCoordinates[0] == firstBlackHoleCoordinates[0]
                    && playerCoordinates[1] == firstBlackHoleCoordinates[1]) {
                playerCoordinates[0] = secondBlackHoleCoordinates[0];
                playerCoordinates[1] = secondBlackHoleCoordinates[1];

                galaxy[firstBlackHoleCoordinates[0]][firstBlackHoleCoordinates[1]] = '-';
            } else if (playerCoordinates[0] == secondBlackHoleCoordinates[0]
                    && playerCoordinates[1] == secondBlackHoleCoordinates[1]) {
                playerCoordinates[0] = firstBlackHoleCoordinates[0];
                playerCoordinates[1] = firstBlackHoleCoordinates[1];

                galaxy[secondBlackHoleCoordinates[0]][secondBlackHoleCoordinates[1]] = '-';
            } else if (Character.isDigit(galaxy[playerCoordinates[0]][playerCoordinates[1]])) {
                starsPower += galaxy[playerCoordinates[0]][playerCoordinates[1]] - '0';
            }

            galaxy[playerCoordinates[0]][playerCoordinates[1]] = 'S';
        }

        if (outOfGalaxy) {
            System.out.println("Bad news, the spaceship went to the void.");

        } else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }

        System.out.println("Star power collected: " + starsPower);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(galaxy[row][col]);
            }

            System.out.println();
        }
    }
}
