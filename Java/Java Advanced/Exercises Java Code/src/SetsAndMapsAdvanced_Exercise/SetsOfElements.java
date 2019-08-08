package SetsAndMapsAdvanced_Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Set<Integer> firstList = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstList.add(sc.nextInt());
        }

        Set<Integer> secondList = new LinkedHashSet<>();

        for (int i = 0; i < m; i++) {
            secondList.add(sc.nextInt());
        }

        firstList.retainAll(secondList);

        firstList.forEach(num -> System.out.print(num + " "));
        System.out.println();

    }
}
