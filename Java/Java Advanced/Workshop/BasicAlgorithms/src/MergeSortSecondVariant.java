import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSortSecondVariant {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int middle = (begin + end) / 2;
        //Left side
        mergeSort(arr, begin, middle);
        //Right side
        mergeSort(arr, middle + 1, end);

        merge(arr, begin, middle, end);
    }

    private static void merge(int[] arr, int begin, int middle, int end) {
        if (middle < 0 || middle >= arr.length - 1 || arr[middle] <= arr[middle + 1]) {
            return;
        }

        int[] helper = new int[arr.length];

        for (int i = begin; i <= end; i++) {
            helper[i] = arr[i];
        }

        int leftIndex = begin;
        int rightIndex = middle + 1;

        for (int i = begin; i <= end; i++) {
            if (leftIndex > middle) {
                arr[i] = helper[rightIndex++];
            } else if (rightIndex > end) {
                arr[i] = helper[leftIndex++];
            } else if (helper[leftIndex] <= helper[rightIndex]) {
                arr[i] = helper[leftIndex++];
            } else {
                arr[i] = helper[rightIndex++];
            }
        }
    }
}
