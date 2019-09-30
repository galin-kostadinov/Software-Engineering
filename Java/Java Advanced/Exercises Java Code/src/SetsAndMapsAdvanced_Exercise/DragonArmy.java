package SetsAndMapsAdvanced_Exercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(sc.nextLine());

        Map<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String[] token = sc.nextLine().split("\\s+".trim());
            String type = token[0];
            String name = token[1];
            int damage;
            int health;
            int armor;

            if (!token[2].equals("null")) {
                damage = Integer.parseInt(token[2]);
            } else {
                damage = 45;
            }

            if (!token[3].equals("null")) {
                health = Integer.parseInt(token[3]);
            } else {
                health = 250;
            }

            if (!token[4].equals("null")) {
                armor = Integer.parseInt(token[4]);
            } else {
                armor = 10;
            }

            if (!dragons.containsKey(type)) {
                TreeMap<String, List<Integer>> statsByNames = new TreeMap<>();

                List<Integer> stats = new ArrayList<>();
                stats.add(damage);
                stats.add(health);
                stats.add(armor);

                statsByNames.put(name, stats);
                dragons.put(type, statsByNames);
            } else {
                TreeMap<String, List<Integer>> statsByNames = dragons.get(type);
                if (!statsByNames.containsKey(name)) {
                    List<Integer> stats = new ArrayList<>();
                    stats.add(damage);
                    stats.add(health);
                    stats.add(armor);
                    statsByNames.put(name, stats);
                } else {
                    List<Integer> stats = statsByNames.get(name);
                    stats.set(0, damage);
                    stats.set(1, health);
                    stats.set(2, armor);
                }
            }
        }

        for (Map.Entry<String, TreeMap<String, List<Integer>>> stringTreeMapEntry : dragons.entrySet()) {
            String type = stringTreeMapEntry.getKey();
            TreeMap<String, List<Integer>> statsByNames = stringTreeMapEntry.getValue();

            double[] averageDamage = {0};
            double[] averageHealth = {0};
            double[] averageArmor = {0};
            statsByNames.values()
                    .forEach(e -> {
                        averageDamage[0] += e.get(0);
                        averageHealth[0] += e.get(1);
                        averageArmor[0] += e.get(2);
                    });
            averageDamage[0] /= statsByNames.size();
            averageHealth[0] /= statsByNames.size();
            averageArmor[0] /= statsByNames.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    type, averageDamage[0], averageHealth[0], averageArmor[0]);

            statsByNames.entrySet()
                    .forEach(kvp -> {
                        String name = kvp.getKey();
                        int damage = kvp.getValue().get(0);
                        int health = kvp.getValue().get(1);
                        int armor = kvp.getValue().get(2);

                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                                name, damage, health, armor);
                    });
        }
    }
}