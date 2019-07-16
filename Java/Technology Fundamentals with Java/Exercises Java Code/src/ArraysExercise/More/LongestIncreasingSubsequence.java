package ArraysExercise.More;

import java.util.*;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seq = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] len = new int[seq.length]; // Save Longest Subsequence in current index
        int[] prev = new int[seq.length]; // Save previous index till int[currentIndex]len
        int bestIndex = CalculateLongestIncreasingSubsequence(seq, len, prev);

        PrintLongestIncreasingSubsequence(seq, prev, bestIndex);
    }

    private static int CalculateLongestIncreasingSubsequence(
            int[] seq, int[] len, int[] prev) {

        int maxIndex = 0;
        int maxLength = 0;

        for (int x = 0; x < seq.length; x++) {
            len[x] = 1;
            prev[x] = -1;
            for (int i = 0; i < x; i++) {
                if (seq[i] < seq[x] && len[i] >= len[x]) {
                    len[x] = len[i] + 1;//Add also current index
                    prev[x] = i;
                }
            }
            if (len[x] > maxLength) {
                maxLength = len[x];
                maxIndex = x;
            }
        }
        return maxIndex;
    }

    static void PrintLongestIncreasingSubsequence(
            int[] seq, int[] prev, int index) {
        List<Integer> lis = new ArrayList<>();

        while (index != -1) {
            lis.add(seq[index]);
            index = prev[index];
        }

        Collections.reverse(lis);

        for (int num : lis) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
