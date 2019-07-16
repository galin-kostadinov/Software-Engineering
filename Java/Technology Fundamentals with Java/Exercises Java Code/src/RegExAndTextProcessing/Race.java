package RegExAndTextProcessing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String validNames = sc.nextLine();

        Pattern patternName = Pattern.compile("(?<name>[A-Za-z]+)");
        Pattern patternDigit = Pattern.compile("(?<digit>\\d{1})");

        Map<String, Integer> personsAchievement = new LinkedHashMap<>();
        String input = "";
        while (!"end of race".equals(input = sc.nextLine())) {
            Matcher matcherName = patternName.matcher(input);
            List<String> matches = new LinkedList<>();
            while (matcherName.find()) {
                matches.add(matcherName.group());
            }
            String currentName = String.join("", matches);

            if (!validNames.contains(currentName)) {
                continue;
            }

            if (!personsAchievement.containsKey(currentName)) {
                personsAchievement.put(currentName, 0);
            }

            Matcher matcherDigits = patternDigit.matcher(input);
            int currentSum = 0;
            while (matcherDigits.find()) {
                currentSum += Integer.parseInt(matcherDigits.group());
            }
            personsAchievement.put(currentName, personsAchievement.get(currentName) + currentSum);
        }

        personsAchievement = personsAchievement
                .entrySet()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        int index = 0;
        for (var person : personsAchievement.entrySet()) {
            String personName = person.getKey();
            index++;
            if (index % 10 == 1 && index != 11) {
                System.out.printf("%d%s place: %s%n", index, "st", personName);
            } else if (index % 10 == 2 && index != 12) {
                System.out.printf("%d%s place: %s%n", index, "nd", personName);
            } else if (index % 10 == 3 && index != 13) {
                System.out.printf("%d%s place: %s%n", index, "rd", personName);
            } else {
                System.out.printf("%d%s place: %s%n", index, "th", personName);
            }
            if (index == 3) {
                break;
            }
        }
    }
}
