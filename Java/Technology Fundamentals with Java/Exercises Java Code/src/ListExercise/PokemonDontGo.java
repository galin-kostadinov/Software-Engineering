package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (numbers.size() > 0) {
            int removedIndex = Integer.parseInt(sc.nextLine());
            int removedNumber;
            if (removedIndex < 0) {
                removedIndex = 0;
                removedNumber = numbers.get(removedIndex);
                numbers.add(1,numbers.get(numbers.size()-1));
            } else if (removedIndex > numbers.size() - 1) {
                removedIndex = numbers.size()-1;
                removedNumber = numbers.get(removedIndex);
                numbers.add(numbers.get(0));
            } else {
                removedNumber = numbers.get(removedIndex);
            }


            sum += removedNumber;
            numbers.remove(removedIndex);
            if (numbers.size()==0){
                break;
            }
            for (int i = 0; i < numbers.size(); i++) {
                int currentNumber = numbers.get(i);
                if (currentNumber <= removedNumber) {
                    numbers.set(i, currentNumber + removedNumber);
                } else {
                    numbers.set(i, currentNumber - removedNumber);
                }
            }
        }
        System.out.println(sum);
    }
}
