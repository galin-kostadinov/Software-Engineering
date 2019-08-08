package SetsAndMapsAdvanced_Exercise;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> countryPopulation = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = sc.nextLine())) {
            String[] token = input.split("\\|");

            String city = token[0];
            String country = token[1];
            long population = Long.parseLong(token[2]);

            countryPopulation.putIfAbsent(country, new LinkedHashMap<>());
            countryPopulation.get(country).putIfAbsent(city, population);
        }

        countryPopulation.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    long firstCountryPopulation = entry1.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::longValue)
                            .sum();

                    long secondCountryPopulation = entry2.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::longValue)
                            .sum();
                    return Long.compare(secondCountryPopulation, firstCountryPopulation);
                })
                .forEach(kvp -> {
                    String country = kvp.getKey();
                    long totalPopulation = kvp.getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::longValue)
                            .sum();

                    System.out.printf("%s (total population: %d)%n", country, totalPopulation);

                    kvp.getValue()
                            .entrySet()
                            .stream()
                            .sorted((cp1, cp2) -> Long.compare(cp2.getValue(), cp1.getValue()))
                            .forEach(cp ->
                                    System.out.printf("=>%s: %d%n", cp.getKey(), cp.getValue()));
                });
    }
}
