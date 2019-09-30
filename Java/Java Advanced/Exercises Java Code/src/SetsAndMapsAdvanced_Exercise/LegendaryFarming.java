package SetsAndMapsAdvanced_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junkMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            boolean enoughQuantity = false;
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        enoughQuantity = true;
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break;
                    }

                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, quantity);
                    } else {
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                    }
                }
            }
            if (enoughQuantity) {
                break;
            }
        }

        keyMaterials
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(e ->
                        System.out.println(String.format("%s: %d", e.getKey(), e.getValue()))
                );

        junkMaterials
                .entrySet()
                .stream()
                .sorted((k1, k2) -> k1.getKey().compareTo(k2.getKey()))
                .forEach(e ->
                        System.out.println(String.format("%s: %d", e.getKey(), e.getValue()))
                );

    }
}

