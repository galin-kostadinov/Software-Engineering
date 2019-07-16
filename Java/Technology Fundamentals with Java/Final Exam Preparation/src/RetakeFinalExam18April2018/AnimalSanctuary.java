package RetakeFinalExam18April2018;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String regex = "n:(?<animalName>[^;]+);t:(?<animalKind>[^;]+);c--(?<animalCountry>[A-Za-z\\s]+)";
        Pattern pattern = Pattern.compile(regex);
        Pattern patternLetters = Pattern.compile("(?<letters>[A-Za-z\\s]+)");
        Pattern patternDigits = Pattern.compile("(?<digits>[\\d]{1})");
        int totalWeight = 0;
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) {
                continue;
            }

            Matcher matcherDigits = patternDigits.matcher(input);
            while (matcherDigits.find()) {
                totalWeight += Integer.parseInt(matcherDigits.group());
            }

            String animalName = matcher.group("animalName");
            String animalKind = matcher.group("animalKind");
            String animalCountry = matcher.group("animalCountry");

            String realName = "";
            Matcher matcherAnimalName = patternLetters.matcher(animalName);
            while (matcherAnimalName.find()) {
                realName += matcherAnimalName.group();
            }

            String realKind = "";
            Matcher matcherAnimalKind = patternLetters.matcher(animalKind);
            while (matcherAnimalKind.find()) {
                realKind += matcherAnimalKind.group();
            }
            System.out.printf("%s is a %s from %s%n", realName, realKind, animalCountry);

        }
        System.out.printf("Total weight of animals: %dKG",totalWeight);
    }
}
