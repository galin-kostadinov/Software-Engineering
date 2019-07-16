package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = "";
        while (!"End".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(tokens[2]);
                    if (tokens[1].equals("left")) {
                        for (int i = 0; i < count; i++) {
                            int firstNum = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(firstNum);
                        }
                    } else if (tokens[1].equals("right")) {
                        for (int i = 0; i < count; i++) {
                            int lastNum = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, lastNum);
                        }
                    }
                    break;
                default:
                    break;
            }

        }
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
