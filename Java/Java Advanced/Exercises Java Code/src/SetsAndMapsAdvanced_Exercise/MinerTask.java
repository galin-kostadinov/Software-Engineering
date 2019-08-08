package SetsAndMapsAdvanced_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String resource = "";
        while (!"stop".equals(resource = reader.readLine())) {
            int newQuantity = Integer.parseInt(reader.readLine());

            if (!map.containsKey(resource)) {
                map.put(resource, 0);
            }

            map.put(resource, map.get(resource) + newQuantity);
        }

        map.entrySet().forEach(e -> {
            System.out.println(String.format("%s -> %d", e.getKey(), e.getValue()));
        });
    }
}