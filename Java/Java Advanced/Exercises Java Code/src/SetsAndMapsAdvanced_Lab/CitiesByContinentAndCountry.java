package SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        while (count-- != 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new LinkedList<>());

            continents.get(continent).get(country).add(city);
        }

        continents.forEach((continent, countryCities) -> {
            System.out.println(continent + ":");
            countryCities.forEach((country, cities) -> {
                System.out.println(String.format("  %s -> %s",
                        country,
                        String.join(", ", cities)));
            });
        });
    }
}
