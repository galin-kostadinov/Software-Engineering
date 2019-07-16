package RegExAndTextProcessing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int messagesCount = Integer.parseInt(sc.nextLine());

        Pattern patternRawMessage = Pattern.compile("(?<letter>[STARstar]{1})");
        List<String> realMessages = new ArrayList<>();

        for (int i = 0; i < messagesCount; i++) {
            String message = sc.nextLine();
            Matcher matcherRawMessage = patternRawMessage.matcher(message);
            int counter = 0;
            while (matcherRawMessage.find()) {
                counter++;
            }
            StringBuilder createMessage = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                createMessage.append((char) (message.charAt(j) - counter));
            }

            realMessages.add(createMessage.toString());
        }
        String regex = "@(?<planetName>[A-Z][a-z]+)(?:[^A-Za-z]*)"
                + ":(?<planetPopulation>\\d+)(?:\\D*)"
                + "!(?<attackType>[A|D])!(?:.*)"
                + "->(?<soldierCount>\\d+)";
        Pattern patternRealMessage = Pattern.compile(regex);

        int attackedPlanetsCount = 0;
        int destroyedPlanetsCount = 0;
        List<String> attackedPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();

        for (int i = 0; i < realMessages.size(); i++) {
            Matcher matcher = patternRealMessage.matcher(realMessages.get(i));
            if (!matcher.find()) {
                continue;
            }
            String planetName = matcher.group("planetName");
            String attackType = matcher.group("attackType");
            if (attackType.equals("A")) {
                if (!attackedPlanet.contains(planetName)) {
                    attackedPlanetsCount++;
                    attackedPlanet.add(planetName);
                }
            } else {
                if (!destroyedPlanet.contains(planetName)) {
                    destroyedPlanetsCount++;
                    destroyedPlanet.add(planetName);
                }
            }
        }
        System.out.printf("Attacked planets: %d%n", attackedPlanetsCount);
            attackedPlanet.stream()
                    .sorted((p1, p2) -> p1.compareToIgnoreCase(p2))
                    .forEach(e -> System.out.printf("-> %s%n", e));
        System.out.printf("Destroyed planets: %d%n", destroyedPlanetsCount);
            destroyedPlanet.stream()
                    .sorted((p1, p2) -> p1.compareToIgnoreCase(p2))
                    .forEach(e -> System.out.printf("-> %s%n", e));

    }
}
