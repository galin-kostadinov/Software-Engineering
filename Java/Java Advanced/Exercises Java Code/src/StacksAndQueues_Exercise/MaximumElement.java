package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int commandCount = Integer.parseInt(sc.nextLine());

        while (commandCount-- > 0) {
            int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if (tokens[0] == 1) {
                numbers.push(tokens[1]);
            } else if (tokens[0] == 2) {
                numbers.pop();
            } else if (tokens[0] == 3) {
                System.out.println(Collections.max(numbers));
            }
        }
    }
}
