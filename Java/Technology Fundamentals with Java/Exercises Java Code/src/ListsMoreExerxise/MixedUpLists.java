package ListsMoreExerxise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);

        List<Integer> firstListNum = createIntegerList(sc.nextLine());
        List<Integer> secondListNum = createIntegerList(sc.nextLine());
        int maxNum;
        int minNum;
        if (firstListNum.size() > secondListNum.size()) {
            maxNum = Math.max(firstListNum.get(firstListNum.size() - 1), firstListNum.get(firstListNum.size() - 2));
            minNum = Math.min(firstListNum.get(firstListNum.size() - 1), firstListNum.get(firstListNum.size() - 2));
            firstListNum.remove(firstListNum.size() - 1);
            firstListNum.remove(firstListNum.size() - 1);
        } else {
            maxNum = Math.max(secondListNum.get(0), secondListNum.get(1));
            minNum = Math.min(secondListNum.get(0), secondListNum.get(1));
            secondListNum.remove(0);
            secondListNum.remove(0);
        }


        List<Integer> result = new ArrayList<>();
        int maxSize = Math.max(firstListNum.size(), secondListNum.size());

        for (int i = 0; i < maxSize; i++) {
            if (firstListNum.size() > i) {
                result.add(firstListNum.get(i));
            }
            if (secondListNum.size() > i) {
                result.add(secondListNum.get(secondListNum.size() - 1 - i));
            }
        }

        result = result.stream().filter(e -> e > minNum && e < maxNum)
                .map(Integer::intValue).collect(Collectors.toList());

        result.sort(Comparator.naturalOrder());
        result.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static List<Integer> createIntegerList(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
