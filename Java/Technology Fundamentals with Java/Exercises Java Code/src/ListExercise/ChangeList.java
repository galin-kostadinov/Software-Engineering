package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!"end".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("Insert")) {
                int element = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.add(index, element);
                }
            } else if (tokens[0].equals("Delete")) {
                int element = Integer.parseInt(tokens[1]);
                numbers = numbers.stream().filter(e -> e != element)
                        .collect(Collectors.toList());
            }
        }
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
