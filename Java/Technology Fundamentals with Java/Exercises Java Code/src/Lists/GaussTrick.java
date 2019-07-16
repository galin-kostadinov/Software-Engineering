package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int size = numbers.size()/2;
        for (int i = 0; i < size; i++) {
            int result = numbers.get(i)+numbers.get(numbers.size()-1);
            numbers.set(i,result);
            numbers.remove(numbers.size()-1);
        }
        for(int num : numbers){
            System.out.print(num+" ");
        }
        System.out.println();


    }
}
