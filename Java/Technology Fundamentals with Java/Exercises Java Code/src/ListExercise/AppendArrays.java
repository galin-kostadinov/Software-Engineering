package ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\|");
        List<Integer> numbers = new ArrayList(0);

        for (int i = input.length - 1; i >= 0; i--) {
            String[] splited = input[i].split("\\s+");

            for (int j = 0; j < splited.length; j++) {
                if (!splited[j].equals("")) {
                    int num = Integer.parseInt(splited[j]);
                    numbers.add(num);
                }
            }
        }
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
