package AssociativeArraysMoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> dwarfs = new LinkedHashMap<>();

        String input = "";
        while (!"Once upon a time".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s*<:>\\s*".trim());
            String dwarfName = token[0];
            String dwarfHatColor = token[1];
            int dwarfPhysics = Integer.parseInt(token[2]);
            String id = dwarfHatColor + ":" + dwarfName;

            if (!dwarfs.containsKey(id)) {
                dwarfs.put(id, dwarfPhysics);
            } else {
                int currentDwarfPhysics = dwarfs.get(id);
                if (dwarfPhysics > currentDwarfPhysics) {
                    dwarfs.put(id, dwarfPhysics);
                }
            }
        }

        dwarfs.entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    int firstDwarfPhysics = d1.getValue();
                    int secondDwarfPhysics = d2.getValue();

                    int sort = Integer.compare(secondDwarfPhysics, firstDwarfPhysics);
                    if (sort == 0) {
                        String firstDwarfsColor = d1.getKey().split(":")[0];
                        String secondDwarfsColor = d2.getKey().split(":")[0];
                        long firstCount = dwarfs.entrySet()
                                .stream()
                                .filter(e -> e.getKey().split(":")[0].equals(firstDwarfsColor))
                                .count();
                        long secondCount = dwarfs.entrySet()
                                .stream()
                                .filter(e -> e.getKey().split(":")[0].equals(secondDwarfsColor))
                                .count();
                        sort = Long.compare(secondCount, firstCount);

                    }
                    return sort;
                })
                .forEach(e -> {
                    String hatColor = e.getKey().split(":")[0];
                    String name = e.getKey().split(":")[1];
                    int physics = e.getValue();
                    System.out.printf("(%s) %s <-> %d%n", hatColor, name, physics);
                });
    }
}
