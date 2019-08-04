package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> elements = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split("\\s+")).forEach(elements::push);

        while (!elements.isEmpty()){
            System.out.printf("%s ", elements.pop());
        }

        System.out.println();
    }
}
