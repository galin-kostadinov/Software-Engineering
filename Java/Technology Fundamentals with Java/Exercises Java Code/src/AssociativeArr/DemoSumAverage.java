package AssociativeArr;

import java.util.Arrays;

public class DemoSumAverage {
    public static void main(String[] args) {
        int[] num = {3,4,5,1};
        int sum = Arrays.stream(num).sum();
        double average = Arrays.stream(num).average().getAsDouble();
        System.out.println(String.format("Num sum is: %d", sum));
        System.out.println(String.format("Average value is: %.2f", average));

    }
}
