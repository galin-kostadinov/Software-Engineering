package RetakeFinalExam18April2018;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> animalsFoodLim = new LinkedHashMap<>();
        Map<String, Integer> animalsCountByArea = new LinkedHashMap<>();

        String input = "";
        while (!"Last Info".equals(input = sc.nextLine())) {
            String[] token = input.split(":");
            String command = token[0];
            String animalName = token[1];
            int food = Integer.parseInt(token[2]);
            String area = token[3];

            if (command.equals("Add")) {
                if (!animalsFoodLim.containsKey(animalName)) {
                    animalsFoodLim.put(animalName, food);
                    if (!animalsCountByArea.containsKey(area)) {
                        animalsCountByArea.put(area, 1);
                    } else {
                        animalsCountByArea.put(area, animalsCountByArea.get(area) + 1);
                    }
                } else {
                    animalsFoodLim.put(animalName, food + animalsFoodLim.get(animalName));
                }
            } else if (command.equals("Feed")) {
                if (animalsFoodLim.containsKey(animalName)) {
                    animalsFoodLim.put(animalName, animalsFoodLim.get(animalName) - food);

                    int currentAnimalFood = animalsFoodLim.get(animalName);
                    if (currentAnimalFood <= 0) {
                        animalsFoodLim.remove(animalName);
                        animalsCountByArea.put(area, animalsCountByArea.get(area) - 1);
                        System.out.printf("%s was successfully fed%n", animalName);
                    }
                }
            }
        }
        System.out.println("Animals:");
        animalsFoodLim.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int sort = Integer.compare(p2.getValue(), p1.getValue());
                    if (sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(kvp -> {
                    String animalName = kvp.getKey();
                    Integer food = kvp.getValue();
                    System.out.printf("%s -> %dg%n", animalName, food);
                });

        System.out.println("Areas with hungry animals:");
        animalsCountByArea.entrySet()
                .stream()
                .filter(kvp -> kvp.getValue() > 0)
                .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .forEach(kvp -> {
                    String area = kvp.getKey();
                    Integer count = kvp.getValue();
                    System.out.printf("%s : %d%n", area, count);
                });
    }
}
