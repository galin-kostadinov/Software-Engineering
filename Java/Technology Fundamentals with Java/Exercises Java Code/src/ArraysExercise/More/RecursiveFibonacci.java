package ArraysExercise.More;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n<0){
            return;
        }
        if (n==0){
            System.out.println(0);
            return;
        }

        long[] fibonaccies = new long[n + 1];
        fibonaccies[0] = 0;
        fibonaccies[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonaccies[i] = -1;
        }

        long fibN = fibonacci(n, fibonaccies);
        System.out.println(fibN);
    }

    public static long fibonacci(int n, long[] fibonaccies) {

        if (fibonaccies[n] != -1) {
            return fibonaccies[n];
        }
        //System.out.println("Calculating fibonacci of " + n);

        long prev = fibonacci(n - 1, fibonaccies);
        long prevPrev = fibonacci(n - 2, fibonaccies);

        long result = prev + prevPrev;
        fibonaccies[n] = result;

        return result;
    }
}
