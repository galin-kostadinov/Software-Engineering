package StacksAndQueues_Exercise;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int elementsCount = tokens[0];
        int countToRemove = tokens[1];
        int checkElementIsPresent = tokens[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsCount)
                .forEach(numbers::push);

        for (int i = 0; i < countToRemove; i++) {
            numbers.pop();
        }

        if (numbers.contains(checkElementIsPresent)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(0);
            } else {
               System.out.println(Collections.min(numbers));
            }
        }
    }
}
