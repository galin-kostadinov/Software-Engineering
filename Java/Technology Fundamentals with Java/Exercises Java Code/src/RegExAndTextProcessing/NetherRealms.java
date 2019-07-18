package RegExAndTextProcessing;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] demons = sc.nextLine().split("[,\\s]+".trim());

        String regexHealth = "(?<health>[^0-9+\\-\\*\\/\\.]{1})";
        String regexDamage = "(?<damage>[-+]?\\d+[\\.]?\\d*)";
        Pattern patternHealth = Pattern.compile(regexHealth);
        Pattern patternDamage = Pattern.compile(regexDamage);

        Pattern patternMultiplication = Pattern.compile("(\\*){1}");
        Pattern patternDivision = Pattern.compile("(\\/){1}");


        Map<String, Map<Integer, Double>> demonsSpecifications = new LinkedHashMap<>();

        for (int i = 0; i < demons.length; i++) {
            String currentDemon = demons[i];


            Matcher matcherHealth = patternHealth.matcher(currentDemon);
            int health = 0;
            while (matcherHealth.find()) {
                health += matcherHealth.group("health").charAt(0);
            }

            Matcher matcherDamage = patternDamage.matcher(currentDemon);
            double damage = 0.0;
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group("damage"));
            }

            Matcher matcherMultiplication = patternMultiplication.matcher(currentDemon);
            Matcher matcherDivision = patternDivision.matcher(currentDemon);
            int multiplicationDivision = 1;
            while (matcherMultiplication.find()) {
                multiplicationDivision *= 2;
            }
            while (matcherDivision.find()) {
                multiplicationDivision /= 2;
            }
            damage *= multiplicationDivision;

            Map<Integer, Double> healthDamage = new LinkedHashMap<>();
            healthDamage.put(health, damage);
            demonsSpecifications.put(currentDemon, healthDamage);
        }

        demonsSpecifications
                .entrySet()
                .stream()
                .sorted((p1, p2) -> p1.getKey().compareTo(p2.getKey()))
                .forEach((kvp) -> {
                    String name = kvp.getKey();
                    Map<Integer, Double> healthDamage = kvp.getValue();
                    int health = healthDamage.keySet().stream().findFirst().get();
                    double damage = healthDamage.values().stream().findFirst().get();

                    System.out.println(String.format(
                            "%s - %d health, %.2f damage",
                            name, health, damage));
                });
    }
}
