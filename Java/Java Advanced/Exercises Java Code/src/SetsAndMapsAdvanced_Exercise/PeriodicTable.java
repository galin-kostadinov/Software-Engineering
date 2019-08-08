package SetsAndMapsAdvanced_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Set<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");

            elements.addAll(Arrays.asList(input));
        }

        String output = String.join(" ", elements);
        System.out.println(output);
    }
}
