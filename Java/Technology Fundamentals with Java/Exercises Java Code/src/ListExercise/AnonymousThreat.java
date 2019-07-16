package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> text = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = "";
        while (!"3:1".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s+");
            String command = token[0];

            if (command.equals("merge")) {
                int startIndex = Integer.parseInt(token[1]);
                int endIndex = Integer.parseInt(token[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > text.size() - 1) {
                    endIndex = text.size() - 1;
                }
                if (startIndex >= endIndex) {
                    continue;
                }

                String mergedItems = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    mergedItems += text.get(i);
                }
                text.subList(startIndex, endIndex + 1).clear();
                text.add(startIndex, mergedItems);

            } else if (command.equals("divide")) {
                int index = Integer.parseInt(token[1]);
                int partitions = Integer.parseInt(token[2]);
                if (partitions <= 1) {
                    continue;
                }

                String dividingItem = text.get(index);
                if (partitions > dividingItem.length()) {
                    partitions = dividingItem.length();
                    if (partitions <= 1) {
                        continue;
                    }
                }
                text.remove(index);
                List<String> dividedItem = divideOperator(partitions, dividingItem);
                text.addAll(index, dividedItem);

            }
        }
        text.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    private static List<String> divideOperator(int partitions, String dividingItem) {
        List<String> dividedItem = new ArrayList<>(0);
        int partLength = dividingItem.length() / partitions;

        for (int j = 0; j < partitions; j++) {
            String onePart = dividingItem.substring(j * partLength, j * partLength + partLength);

            if (j == partitions - 1) {
                onePart = dividingItem.substring(j * partLength);
            }
            dividedItem.add(onePart);
        }
        return dividedItem;
    }

}
