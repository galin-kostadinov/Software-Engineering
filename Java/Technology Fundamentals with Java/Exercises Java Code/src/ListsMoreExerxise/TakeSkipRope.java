package ListsMoreExerxise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String initialText = sc.nextLine();

        List<String> nonNumbersList = new ArrayList<>();
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < initialText.length(); i++) {
            char symbol = initialText.charAt(i);
            if (Character.isDigit(symbol)) {
                int number = symbol - '0';
                numbersList.add(number);
            } else {
                nonNumbersList.add(symbol + "");
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbersList.get(i));
            } else {
                skipList.add(numbersList.get(i));
            }
        }

        List<String> text = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        int i = 0;
        while (nonNumbersList.size() > startIndex && nonNumbersList.size() > endIndex && i < takeList.size()) {

            endIndex += takeList.get(i);

            if (endIndex > nonNumbersList.size()) {
                endIndex = nonNumbersList.size();
            }

            List<String> currentList = nonNumbersList.subList(startIndex, endIndex);
            if (currentList.size() > 0) {
                text.addAll(currentList);
            }

            endIndex += skipList.get(i);
            startIndex = endIndex;
            i++;
        }

        text.forEach(e -> System.out.print(e));
        System.out.println();
    }

}

