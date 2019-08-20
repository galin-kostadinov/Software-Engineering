package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readIntegerArray(scanner.nextLine());

        Galactic galactic = new Galactic(dimensions[0], dimensions[1]);

        Player player = new Player();

        GalacticCluster cluster = new GalacticCluster(galactic);

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] playerPositions = readIntegerArray(command);

            int playerRow = playerPositions[0];
            int playerCol = playerPositions[1];

            int[] evilPosition = readIntegerArray(scanner.nextLine());

            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            cluster.moveEvilForce(evilRow, evilCol);

            long starsToAdd = cluster.collectPlayerStars(playerRow, playerCol);

            player.addStars(starsToAdd);

            command = scanner.nextLine();
        }

        System.out.println(player.getStars());
    }

    public static int[] readIntegerArray(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
