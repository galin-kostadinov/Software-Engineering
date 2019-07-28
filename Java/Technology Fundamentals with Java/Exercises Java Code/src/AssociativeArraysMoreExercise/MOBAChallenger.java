package AssociativeArraysMoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> playerPool = new LinkedHashMap<>();

        String input = "";
        while (!"Season end".equals(input = sc.nextLine())) {
            if (input.contains("->")) {
                String[] token = input.split("\\s*->\\s*".trim());
                String player = token[0];
                String position = token[1];
                int skill = Integer.parseInt(token[2]);

                if (!playerPool.containsKey(player)) {
                    LinkedHashMap<String, Integer> posSkill = new LinkedHashMap<>();
                    posSkill.put(position, skill);
                    playerPool.put(player, posSkill);
                } else {
                    LinkedHashMap<String, Integer> posSkill = playerPool.get(player);
                    if (!posSkill.containsKey(position)) {
                        posSkill.put(position, skill);
                    } else {
                        int currentSkill = posSkill.get(position);
                        if (skill > currentSkill) {
                            posSkill.put(position, skill);
                        }
                    }
                }
            } else {
                String[] token = input.split("\\s*vs\\s*".trim());
                String firstPlayer = token[0];
                String secondPlayer = token[1];
                if (playerPool.containsKey(firstPlayer) && playerPool.containsKey(secondPlayer)) {
                    LinkedHashMap<String, Integer> posSkillFirstPlayer = playerPool.get(firstPlayer);
                    LinkedHashMap<String, Integer> posSkillSecondPlayer = playerPool.get(secondPlayer);

                    if (posSkillFirstPlayer.keySet().containsAll(posSkillSecondPlayer.keySet())) {
                        int totalPointFirstPlayer = getTotalPoint(posSkillFirstPlayer);
                        int totalPointSecondPlayer = getTotalPoint(posSkillSecondPlayer);

                        if (totalPointFirstPlayer < totalPointSecondPlayer) {
                            playerPool.remove(firstPlayer);
                        } else if (totalPointFirstPlayer > totalPointSecondPlayer) {
                            playerPool.remove(secondPlayer);
                        }
                    }
                }
            }
        }

        playerPool.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    String firstPlayerName = p1.getKey();
                    String secondPlayerName = p2.getKey();
                    LinkedHashMap<String, Integer> posSkillFirstPlayer = p1.getValue();
                    LinkedHashMap<String, Integer> posSkillSecondPlayer = p2.getValue();

                    int totalPointFirstPlayer = getTotalPoint(posSkillFirstPlayer);
                    int totalPointSecondPlayer = getTotalPoint(posSkillSecondPlayer);

                    int sort = Integer.compare(totalPointSecondPlayer, totalPointFirstPlayer);

                    if (sort == 0) {
                        sort = firstPlayerName.compareTo(secondPlayerName);
                    }
                    return sort;
                })
                .forEach(p->{
                    String playerName = p.getKey();
                    LinkedHashMap<String, Integer> posSkillPlayer = p.getValue();
                    int totalPointPlayer = getTotalPoint(posSkillPlayer);

                    System.out.printf("%s: %d skill", playerName, totalPointPlayer);


                });

    }

    private static int getTotalPoint(LinkedHashMap<String, Integer> posSkillPlayer) {
        return posSkillPlayer
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

