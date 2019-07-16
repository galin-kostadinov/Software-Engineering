package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstNumList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> allNumbers = new ArrayList<>();
        int maxSize = Math.max(firstNumList.size(), secondNumList.size());

        for (int i = 0; i <maxSize ; i++) {
            if (firstNumList.size() > i){
                allNumbers.add(firstNumList.get(i));
            }
            if (secondNumList.size() > i){
                allNumbers.add(secondNumList.get(i));
            }
        }

        for(int item : allNumbers){
            System.out.print(item+" ");
        }
        System.out.println();
    }
}
