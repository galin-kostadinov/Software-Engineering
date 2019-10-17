import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s++")).map(Integer::parseInt).forEach(num -> leftSocks.push(num));
        Arrays.stream(reader.readLine().split("\\s++")).map(Integer::parseInt).forEach(num -> rightSocks.offer(num));

        List<Integer> pair = new LinkedList<>();

        while (!leftSocks.isEmpty() && !rightSocks.isEmpty()) {
            int left = leftSocks.peek();
            int right = rightSocks.peek();

            if (left > right) {
                pair.add(left + right);
                leftSocks.pop();
                rightSocks.poll();
            } else if (left < right) {
                leftSocks.pop();
            } else {
                rightSocks.poll();
                leftSocks.pop();
                leftSocks.push(left + 1);
            }
        }

        int max = Collections.max(pair);

        System.out.println(max);

        pair.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
