import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int key = Integer.parseInt(sc.nextLine());

        int resultIndex = binarySearch(input, key, 0, input.length - 1);

        System.out.println(resultIndex);
    }

    public static int binarySearch(int arr[], int key, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;

            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
