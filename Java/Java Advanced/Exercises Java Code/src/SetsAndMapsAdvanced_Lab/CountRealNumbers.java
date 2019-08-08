package SetsAndMapsAdvanced_Lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        Map<Double, Integer> result = new LinkedHashMap<>();

        for (String currentElement : input) {
            Double key = Double.parseDouble(currentElement);
            if (!result.containsKey(key)) {
                result.put(key, 0);
            }

            result.put(key, result.get(key) + 1);
        }

        for (Map.Entry<Double, Integer> kvp : result.entrySet()) {

            System.out.printf("%.1f -> %d%n", kvp.getKey(), kvp.getValue());
        }
    }
}
