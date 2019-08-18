import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = calcSum(arr, arr.length - 1);

        System.out.println(sum);
    }

    private static int calcSum(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        }

        return arr[index] + calcSum(arr, index - 1);
    }
}
