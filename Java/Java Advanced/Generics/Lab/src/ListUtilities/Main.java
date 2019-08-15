package ListUtilities;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListUtils comparator = new ListUtils();

        System.out.println("Min = " + comparator.getMin(Arrays.asList(10, 3, 5, 66, 23, 45, 23, 32, 42)));
        System.out.println("Max = " + comparator.getMax(Arrays.asList(10, 3, 5, 66, 23, 45, 23, 32, 42)));

        System.out.println("First Alphabetically = " + comparator.getMin(Arrays.asList("Ana", "Stefan", "Galin", "Martin")));
        System.out.println("Last Alphabetically = " + comparator.getMax(Arrays.asList("Ana", "Stefan", "Galin", "Martin")));
    }
}
