import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        long sum = calcFactorial(n);

        System.out.println(sum);
    }

    private static int calcFactorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * calcFactorial(n - 1);
    }
}
