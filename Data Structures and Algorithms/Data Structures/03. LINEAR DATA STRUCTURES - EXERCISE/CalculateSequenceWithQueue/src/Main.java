import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int count = 50;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> queuePrint = new ArrayDeque<>(50);
        queue.offer(n);

        while (count-- > 0) {
            int s1 = queue.poll();
            queuePrint.offer(s1);
            queue.offer(s1 + 1);
            queue.offer(2 * s1 + 1);
            queue.offer(s1 + 2);
        }

        System.out.println(queuePrint.toString().replaceAll("[\\[\\]]", ""));
    }
}
