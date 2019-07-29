package AssociativeArr;

import java.util.*;
import java.util.stream.Collectors;

public class DemoStreamAPI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[]{1, 2, 3, 4, 5};

        IntSummaryStatistics y = Arrays.stream(nums).summaryStatistics();
        int yMin = y.getMin();
        double yAverage = y.getAverage();
        System.out.println("Min y = " + yMin);
        System.out.println("Average y = " + yAverage);

        /*---------------------------------------------------------------*/

        Integer[] nums1 = new Integer[]{1, 2, 3, 4, 5};

        OptionalInt z = Arrays.stream(nums).min();
        if (z != null) {
            System.out.println("Min z = " + z.getAsInt());
        } else {
            System.out.println("no elements");
        }

        /*---------------------------------------------------------------*/

        List<Integer> numbers = new ArrayList<>(Arrays.asList(-5, 1, 2, 3, 4, 5));

        Optional<Integer> x1 = numbers.stream().min(Comparator.naturalOrder()); // Min

        Optional<Integer> x2 = numbers.stream().min(Comparator.reverseOrder()); // Max
        Optional<Integer> x3 = numbers.stream().max(Comparator.naturalOrder()); // Max
        Optional<Integer> x4 = numbers.stream().max((a, b) -> Integer.compare(a, b)); // Max
        Optional<Integer> x5 = numbers.stream().max((a, b) -> Integer.compare(b, a)); // Min
        Optional<Integer> x6 = numbers.stream().max((a, b) -> a.compareTo(b));  // Max
        /* We can use a.compareTo(b) instead Integer.compare(a, b),
         because we use "Integer" - this is object not primitive "int"
         */

        Optional<Integer> sum = numbers.stream().reduce((current, newValue) -> current + newValue);
        System.out.println("sum = " + sum.get());


        if (x1.isPresent()) {
            System.out.println("Min x1 = " + x1.get());
        } else {
            System.out.println("no elements");
        }

        /*---------------------------------------------------------------*/

        List<String> names = new ArrayList<>(Arrays.asList("Z", "Ani", "Maria", "Stefan", "T"));

        Optional<String> name = names.stream().min((a, b) -> a.compareTo(b));// First object Alphabetically
        System.out.println(name.get());

        /*---------------------------------------------------------------*/

        List<Integer> nums2 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(i -> i * 2)
                .collect(Collectors.toList());

        /*---------------------------------------------------------------*/

        List<Integer> num4 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        /*---------------------------------------------------------------*/

        String[] text = sc.nextLine().split("\\s+");
        List<String> text1 = Arrays.asList(sc.nextLine().split("\\s+"));
    }
}