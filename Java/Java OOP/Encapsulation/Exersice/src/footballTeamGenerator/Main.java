package footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");
            String command = tokens[0];

            if (command.equals("Team")) {
                try {
                    Team team = new Team(tokens[1]);
                    teams.put(tokens[1], team);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (command.equals("Add")) {
                String teamName = tokens[1];
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);

                if (!teams.containsKey(teamName)) {
                    System.out.println("Team " + teamName + " does not exist.");
                } else {
                    try {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

            } else if (command.equals("Remove")) {
                String teamName = tokens[1];
                String playerName = tokens[2];
                teams.get(teamName).removePlayer(playerName);
            } else if (command.equals("Rating")) {
                String teamName = tokens[1];
                if (!teams.containsKey(teamName)) {
                    System.out.println(String.format("Team %s does not exist.", teamName));
                } else {
                    System.out.println(String.format("%s - %.0f", teamName, teams.get(teamName).getRating()));
                }
            }
        }
    }
}
