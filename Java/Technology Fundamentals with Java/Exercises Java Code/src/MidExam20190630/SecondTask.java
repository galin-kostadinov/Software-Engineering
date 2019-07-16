package MidExam20190630;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecondTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        String input = "";
        while (!"End".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s+");
            if (input.contains("Switch")) {
                int index = Integer.parseInt(token[1]);
                if (index >= 0 && index < numbers.size()) {
                    int num = -numbers.get(index);
                    numbers.set(index, num);
                }
            } else if (input.contains("Change")) {
                int index = Integer.parseInt(token[1]);
                int value = Integer.parseInt(token[2]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.set(index, value);
                }

            } else if (input.contains("Sum Negative")) {

                int sum = numbers.stream().filter(e -> e <= 0).mapToInt(Integer::intValue).sum();
                System.out.println(sum);

            } else if (input.contains("Sum Positive")) {
                int sum = numbers.stream().filter(e -> e >= 0).mapToInt(Integer::intValue).sum();
                System.out.println(sum);
            } else if (input.contains("Sum All")) {
                int sum = numbers.stream().mapToInt(Integer::intValue).sum();
                System.out.println(sum);
            }

        }
        numbers.stream()
                .filter(e -> e >= 0)
                .forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }
}
