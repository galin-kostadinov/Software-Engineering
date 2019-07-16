package FinalExam14April2019GroupII;

import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> roadRacers = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("\\s*->\\s*");
            String command = token[0];
            String road = token[1];

            if (command.equals("Add")) {
                String racer = token[2];
                if (!roadRacers.containsKey(road)) {
                    List<String> racers = new ArrayList<>();
                    racers.add(racer);
                    roadRacers.put(road, racers);
                } else {
                    List<String> racers = roadRacers.get(road);
                    racers.add(racer);
                }
            } else if (command.equals("Move")) {
                String racer = token[2];
                String nextRoad = token[3];
                List<String> currentRoad = roadRacers.get(road);
                List<String> nextRoadRacers = roadRacers.get(nextRoad);
                if (currentRoad.contains(racer)) {
                    currentRoad.remove(racer);
                    nextRoadRacers.add(racer);
                }

            } else if (command.equals("Close")) {
                roadRacers.remove(road);
            }
            input = sc.nextLine();
        }

        System.out.println("Practice sessions:");
        roadRacers.entrySet()
                .stream()
                .sorted((kvp1, kvp2) -> {
                    List<String> firstRoadRacers = kvp1.getValue();
                    List<String> secondRoadRacers = kvp2.getValue();

                    int sort = Integer.compare(secondRoadRacers.size(), firstRoadRacers.size());

                    if (sort == 0) {
                        sort = kvp1.getKey().compareTo(kvp2.getKey());
                    }

                    return sort;
                })
                .forEach(kvp -> {
                    String currentRoad = kvp.getKey();
                    List<String> currentRoadRacers = kvp.getValue();
                    System.out.println(currentRoad);
                    currentRoadRacers.forEach(e -> System.out.printf("++%s%n", e));
                });
    }
}
