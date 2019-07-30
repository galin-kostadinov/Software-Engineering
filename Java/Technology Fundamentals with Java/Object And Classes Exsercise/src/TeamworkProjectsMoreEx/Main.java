package TeamworkProjectsMoreEx;

import java.io.Console;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        List<Team> teams = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            String[] createInput = sc.nextLine().split("-");
            String creatorName = createInput[0];
            String teamName = createInput[1];

            boolean isTeamNameExist = teams.stream().anyMatch(x -> x.getName().equals(teamName));
            boolean isCreatorNameExist = teams.stream().anyMatch(x -> x.getCreatorName().equals(creatorName));

            if (isTeamNameExist) {
                System.out.printf("Team %s was already created!%n", teamName);
            }
            if (isCreatorNameExist) {
                System.out.printf("%s cannot create another team!%n", creatorName);
            }
            if (!isTeamNameExist && !isCreatorNameExist) {
                Team team = new Team(teamName, creatorName, new ArrayList<>());
                teams.add(team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);
            }
        }

        String input = "";
        while (!"end of assignment".equals(input = sc.nextLine())) {
            String[] joinInput = input.split("->");
            String user = joinInput[0];
            String teamName = joinInput[1];

            boolean isTeamNameExist = teams.stream().anyMatch(x -> x.getName().equals(teamName));
            boolean isExistMember = teams.stream().anyMatch(x -> x.getMembers().contains(user) || x.getCreatorName().equals(user));

            if (!isTeamNameExist) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else if (isExistMember) {
                System.out.printf("Member %s cannot join team %s!%n", user, teamName);
            }
            if (isTeamNameExist && !isExistMember) {
                teams.stream().filter(x -> x.getName().equals(teamName)).findFirst().get().getMembers().add(user);
            }
        }

        teams.stream()
                .filter(e -> e.getMembers().size() > 0)
                .sorted((t1, t2) -> {
                    int sort = Integer.compare(t2.getMembers().size(), t1.getMembers().size());
                    if (sort == 0) {
                        sort = t1.getName().compareTo(t2.getName());
                    }
                    return sort;
                })
                .forEach(e -> {
                    System.out.println(e.getName());
                    System.out.printf("- %s%n", e.getCreatorName());
                    e.getMembers().stream().sorted((e1, e2) -> e1.compareTo(e2)).forEach(m -> System.out.printf("-- %s%n", m));
                });

        System.out.println("Teams to disband:");

        teams.stream()
                .filter(e -> e.getMembers().size() == 0)
                .sorted(Comparator.comparing(Team::getName))
                .forEach(e -> System.out.println(e.getName()));
    }
}

