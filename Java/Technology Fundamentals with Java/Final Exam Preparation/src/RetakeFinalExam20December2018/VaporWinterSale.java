package RetakeFinalExam20December2018;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        Map<String, Double> gamesPrices = new LinkedHashMap<>();
        Map<String, String> gamesDLC = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String currentGame = input[i];
            if (currentGame.contains("-")) {
                String[] token = currentGame.split("-");
                String gameName = token[0];
                double price = Double.parseDouble(token[1]);
                if (!gamesPrices.containsKey(gameName)) {
                    gamesPrices.put(gameName, price);
                }

            } else if (currentGame.contains(":")) {
                String[] token = currentGame.split(":");
                String gameName = token[0];
                String DLC = token[1];

                if (gamesPrices.containsKey(gameName)) {
                    gamesDLC.put(gameName, DLC);
                    gamesPrices.put(gameName, gamesPrices.get(gameName) * 1.2);
                }
            }
        }
        gamesPrices.entrySet()
                .stream()
                .sorted((g1,g2)-> Double.compare(g1.getValue(),g2.getValue()))
                .forEach(kvp->{
                    String name = kvp.getKey();
                    double price = kvp.getValue();
                    if (gamesDLC.containsKey(name)){
                        String DCL = gamesDLC.get(name);
                        price*=0.5;
                        System.out.printf("%s - %s - %.2f%n", name, DCL, price);
                    }
                });

        gamesPrices.entrySet()
                .stream()
                .sorted((g1,g2)-> Double.compare(g2.getValue(),g1.getValue()))
                .forEach(kvp->{
                    String name = kvp.getKey();
                    double price = kvp.getValue();
                    if (!gamesDLC.containsKey(name)){
                        price*=0.8;
                        System.out.printf("%s - %.2f%n", name, price);
                    }
                });

    }
}
