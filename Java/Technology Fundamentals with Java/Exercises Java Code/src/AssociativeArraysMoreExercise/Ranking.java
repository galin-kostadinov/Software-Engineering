package AssociativeArraysMoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> validContest = new LinkedHashMap<>();

        String input = "";

        while (!"end of contests".equals(input = sc.nextLine())) {
            String[] token = input.split(":");
            String contest = token[0];
            String password = token[1];
            validContest.put(contest, password);
        }

        Map<String, LinkedHashMap<String, Integer>> userInf = new TreeMap<>();

        while (!"end of submissions".equals(input = sc.nextLine())) {
            String[] token = input.split("=>");
            String currentContest = token[0];
            String currentPassword = token[1];
            String username = token[2];
            int points = Integer.parseInt(token[3]);

            if (validContest.containsKey(currentContest)) {
                String validPass = validContest.get(currentContest);
                if (validPass.equals(currentPassword)) {
                    if (!userInf.containsKey(username)) {
                        LinkedHashMap<String, Integer> currentContestPoints = new LinkedHashMap<>();
                        currentContestPoints.put(currentContest, points);
                        userInf.put(username, currentContestPoints);
                    } else {
                        LinkedHashMap<String, Integer> currentContestPoints = userInf.get(username);
                        if (currentContestPoints.containsKey(currentContest)) {
                            int savedPoints = currentContestPoints.get(currentContest);
                            if (savedPoints < points) {
                                currentContestPoints.put(currentContest, points);
                            }
                        } else {
                            currentContestPoints.put(currentContest, points);
                        }
                    }
                }
            }
        }

        String bestUser = "";
        int points = 0;

        for (Map.Entry<String, LinkedHashMap<String, Integer>> stringLinkedHashMapEntry : userInf.entrySet()) {
            String currentUser = stringLinkedHashMapEntry.getKey();
            int currentPoints = stringLinkedHashMapEntry
                    .getValue()
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            if (currentPoints > points) {
                bestUser = currentUser;
                points = currentPoints;
            }
        }

        if (!bestUser.equals("")) {
            System.out.printf("Best candidate is %s with total %d points.%n", bestUser, points);
        }

        if (userInf.size() > 0) {
            System.out.println("Ranking:");
            userInf.entrySet()
                    .forEach(kvp -> {
                        String username = kvp.getKey();
                        Map<String, Integer> contestPoints = kvp.getValue();
                        System.out.println(username);
                        contestPoints.entrySet()
                                .stream()
                                .sorted((cp1, cp2) -> Integer.compare(cp2.getValue(), cp1.getValue()))
                                .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
                    });
        }
    }
}