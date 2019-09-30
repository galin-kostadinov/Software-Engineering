package SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "^(?<singer>([A-Za-z]+\\s)+)@(?<venue>([A-Za-z]+\\s)+)"
                + "(?<ticketsPrice>\\d+)\\s{1}(?<ticketsCount>\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        //venue->singer->income
        Map<String, LinkedHashMap<String, Integer>> concert = new LinkedHashMap<>();

        String input;

        while (!"End".equals(input = sc.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("singer");
                singer = singer.substring(0, singer.length() - 1);

                String venue = matcher.group("venue");
                venue = venue.substring(0, venue.length() - 1);

                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));
                int income = ticketsPrice * ticketsCount;

                concert.putIfAbsent(venue, new LinkedHashMap<>());
                concert.get(venue).putIfAbsent(singer, 0);
                concert.get(venue).put(singer, concert.get(venue).get(singer) + income);
            }
        }
        System.out.println();
        for (var kvp : concert.entrySet()) {
            String venue = kvp.getKey();
            System.out.println(venue);

            kvp.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> {
                        String singer = e.getKey();
                        int income = e.getValue();
                        System.out.printf("#  %s -> %d%n", singer, income);
                    });
        }
    }
}

