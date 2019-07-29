package AssociativeArr;

import java.util.*;

public class DemoStreamAPI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[]{1, 2, 3, 4, 5};

        IntSummaryStatistics y = Arrays.stream(nums).summaryStatistics();
        int yMin = y.getMin();
        double yAverage = y.getAverage();

        /*---------------------------------------------------------------*/

        Integer[] nums1 = new Integer[]{1, 2, 3, 4, 5};

        OptionalInt z = Arrays.stream(nums).min();
        if (z != null) {
            System.out.println(z);
        } else {
            System.out.println("no elements");
        }

        /*---------------------------------------------------------------*/

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Optional<Integer> x1 = numbers.stream().min(Comparator.naturalOrder()); // Min

        Optional<Integer> x2 = numbers.stream().min(Comparator.reverseOrder()); // Max
        Optional<Integer> x3 = numbers.stream().max(Comparator.naturalOrder()); // Max
        Optional<Integer> x4 = numbers.stream().max((a, b) -> Integer.compare(a, b)); // Max
        Optional<Integer> x5 = numbers.stream().max((a, b) -> Integer.compare(b, a)); // Min
        Optional<Integer> x6 = numbers.stream().max((a, b) -> a.compareTo(b));  // Max
        /* We can use a.compareTo(b) instead Integer.compare(a, b),
         because we use "Integer" - this is object not primitive "int"
         */

        if (x1.isPresent()) {
            System.out.println(x1.get());
        } else {
            System.out.println("no elements");
        }
    }

}
