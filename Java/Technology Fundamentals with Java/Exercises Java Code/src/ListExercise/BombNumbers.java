package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] token = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bombNumber = token[0];
        int power = token[1];

        while (numbers.contains(bombNumber)) {
            int bombIndex = numbers.indexOf(bombNumber);
            int startIndex = bombIndex - power;
            int endIndex = bombIndex + power;
            if (startIndex < 0) {
                startIndex = 0;
            }
            if (endIndex > numbers.size() - 1) {
                endIndex = numbers.size() - 1;
            }
            numbers.subList(startIndex, endIndex + 1).clear();

        }

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
