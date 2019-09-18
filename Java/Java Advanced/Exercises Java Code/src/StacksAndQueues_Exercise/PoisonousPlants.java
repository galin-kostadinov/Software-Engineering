package StacksAndQueues_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> indexToRemove = new ArrayDeque<>();

        int initialPlantsCount = Integer.parseInt(reader.readLine());

        List<Integer> plants = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int days = 0;

        while (plants.size() > 1) {
            int plantsSize = plants.size();
            for (int i = 1; i < plantsSize; i++) {
                if (plants.get(i - 1) < plants.get(i)) {
                    indexToRemove.push(i);
                }
            }

            if (indexToRemove.isEmpty()) {
                break;
            }

            while (!indexToRemove.isEmpty()) {
                int index = indexToRemove.pop();
                plants.remove(index);
            }

            days++;
        }

        System.out.println(days);
    }
}
