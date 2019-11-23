import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int systemsCount = Integer.parseInt(reader.readLine());
        int reportCount = Integer.parseInt(reader.readLine());
        int size = Integer.parseInt(reader.readLine());

        List<StarSystem> systems = new ArrayList<>();

        for (int i = 0; i < systemsCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[2]);

            systems.add(new StarSystem(x, y, name));
        }

        Collections.sort(systems);

        for (int i = 0; i < reportCount; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            int x1 = Integer.parseInt(tokens[1]);
            int y1 = Integer.parseInt(tokens[2]);
            int x2 = x1 + Integer.parseInt(tokens[3]);
            int y2 = y1 + Integer.parseInt(tokens[4]);

            printGalaxiesInRange(x1, y1, x2, y2, systems);
        }
    }

    private static void printGalaxiesInRange(
            int x1, int y1, int x2, int y2,

            List<StarSystem> starSystemsList) {
        int galaxiesInRange = 0;

        for (var starSystem : starSystemsList) {
            if (x1 > starSystem.getX() || y1 > starSystem.getY() || y2 < starSystem.getY()) {
                continue;
            }

            if (x2 < starSystem.getX()) {
                break;
            }

            if (starSystem.isInto(x1, y1, x2, y2)) {
                galaxiesInRange++;
            }
        }

        System.out.println(galaxiesInRange);
    }
}
