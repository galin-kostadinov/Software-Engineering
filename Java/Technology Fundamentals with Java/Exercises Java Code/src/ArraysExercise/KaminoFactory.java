package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sequenseLength = Integer.parseInt(sc.nextLine());

        int[] bestDNA = new int[sequenseLength];
        int bestSequenceIndex = Integer.MAX_VALUE;
        int longestSubsequence = 0;
        int bestSequenceSum = 0;
        int indexOfDNA = 1;
        int counter = 1;

        while (true) {
            String input = sc.nextLine();
            if (input.equals("Clone them!")) {
                break;
            }

            int[] currentDNA = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();

//            int[] currentDNA = Arrays.stream(input.split("!+"))
//                    .filter(e -> !e.equals(""))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();

            int currenSequenceSum = Arrays.stream(currentDNA).sum();
            int currentSequenceBestLength = 0;
            int currentSequenceBestIndex = 0;
            int currentSequenceLength = 0;
            int currentSequenceIndex = 0;


            for (int i = 0; i < currentDNA.length - 1; i++) {
                if (currentDNA[i] == 1 && currentDNA[i] == currentDNA[i + 1] && currentSequenceLength == 0) {
                    currentSequenceLength = 2;
                    currentSequenceIndex = i;
                } else if (currentDNA[i] == 1 && currentDNA[i] == currentDNA[i + 1] && currentSequenceLength > 0) {
                    currentSequenceLength++;
                } else if (currentDNA[i] == 0 && currentSequenceLength > 0) {
                    if (currentSequenceBestLength < currentSequenceLength) {
                        currentSequenceBestLength = currentSequenceLength;
                        currentSequenceBestIndex = currentSequenceIndex;
                    }
                    currentSequenceLength = 0;
                    currentSequenceIndex = 0;
                }
            }

            if (currentSequenceBestLength == 0) {
                for (int i = 0; i < currentDNA.length; i++) {
                    if (currentDNA[i] == 1) {
                        currentSequenceBestLength = 1;
                        currentSequenceBestIndex = i;
                        break;
                    }
                }
            }

            if (longestSubsequence < currentSequenceBestLength) {
                bestDNA = currentDNA;
                bestSequenceIndex = currentSequenceBestIndex;
                longestSubsequence = currentSequenceBestLength;
                bestSequenceSum = currenSequenceSum;
                indexOfDNA = counter;
            } else if (longestSubsequence == currentSequenceBestLength) {
                if (bestSequenceIndex > currentSequenceBestIndex) {
                    bestDNA = currentDNA;
                    bestSequenceIndex = currentSequenceBestIndex;
                    longestSubsequence = currentSequenceBestLength;
                    bestSequenceSum = currenSequenceSum;
                    indexOfDNA = counter;
                } else if (bestSequenceIndex == currentSequenceBestIndex) {
                    if (bestSequenceSum < currenSequenceSum) {
                        bestDNA = currentDNA;
                        bestSequenceIndex = currentSequenceBestIndex;
                        longestSubsequence = currentSequenceBestLength;
                        bestSequenceSum = currenSequenceSum;
                        indexOfDNA = counter;
                    }
                }
            }
            counter++;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n",
                indexOfDNA, bestSequenceSum);
        for (int number : bestDNA) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
