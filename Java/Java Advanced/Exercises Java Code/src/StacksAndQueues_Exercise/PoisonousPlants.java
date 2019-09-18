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

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        List<Integer> plants = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        indexes.push(0);

        int[] days = new int[n];

        for (int i = 1; i < n; i++) {
            int maxDays = 0;
            while (indexes.size() > 0 && plants.get(indexes.peek())>= plants.get(i)) {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }

            if (indexes.size() > 0) {
                days[i] = maxDays + 1;
            }

            indexes.push(i);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
