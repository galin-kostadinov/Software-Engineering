package AssociativeArraysMoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> contestUsersPoints = new LinkedHashMap<>();

        String input = "";
        while (!"no more time".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s*->\\s*".trim());
            String currentUsername = token[0];
            String contest = token[1];
            int currenPoints = Integer.parseInt(token[2]);

            if (!contestUsersPoints.containsKey(contest)) {
                LinkedHashMap<String, Integer> usersPoints = new LinkedHashMap<>();
                usersPoints.put(currentUsername, currenPoints);
                contestUsersPoints.put(contest, usersPoints);
            } else {
                LinkedHashMap<String, Integer> usersPoints = contestUsersPoints.get(contest);
                if (!usersPoints.containsKey(currentUsername)) {
                    usersPoints.put(currentUsername, currenPoints);
                } else {
                    int dbPoints = usersPoints.get(currentUsername);
                    if (currenPoints > dbPoints) {
                        usersPoints.put(currentUsername, currenPoints);
                    }
                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> kvp : contestUsersPoints.entrySet()) {
            int countOfParticipant = kvp.getValue().size();
            String contest = kvp.getKey();
            System.out.printf("%s: %d participants%n", contest, countOfParticipant);

            int[] index = {1};

            kvp.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        int sort = Integer.compare(e2.getValue(), e1.getValue());

                        if (sort == 0) {
                            sort = e1.getKey().compareTo(e2.getKey());
                        }
                        return sort;
                    })
                    .forEach(e -> {
                        String username = e.getKey();
                        int points = e.getValue();
                        System.out.printf("%d. %s <::> %d%n", index[0], username, points);
                        index[0]++;
                    });
        }

        Map<String, Integer> usersPoints = new LinkedHashMap<>();

        for (LinkedHashMap<String, Integer> kvp : contestUsersPoints.values()) {
            for (Map.Entry<String, Integer> userPoints : kvp.entrySet()) {
                String currantUser = userPoints.getKey();
                int currantPoints = userPoints.getValue();
                if (!usersPoints.containsKey(currantUser)) {
                    usersPoints.put(currantUser, currantPoints);
                } else {
                    usersPoints.put(currantUser, usersPoints.get(currantUser) + currantPoints);
                }
            }
        }

        System.out.println("Individual standings:");

        int[] index = {1};
        usersPoints.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach(e -> {
            String username = e.getKey();
            int points = e.getValue();
            System.out.printf("%d. %s -> %d%n", index[0], username, points);
            index[0]++;
        });
    }
}