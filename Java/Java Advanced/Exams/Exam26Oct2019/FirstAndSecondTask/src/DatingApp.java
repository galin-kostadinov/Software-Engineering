import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*


Matches: 4
Males left: none
Females left: 15, 13, 4

         */

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s++")).forEach(s -> malesStack.push(Integer.parseInt(s)));
        Arrays.stream(reader.readLine().split("\\s++")).forEach(s -> femalesQueue.offer(Integer.parseInt(s)));

        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.pop();

            if (male <= 0) {
                continue;
            }
            if (male % 25 == 0) {
                male = malesStack.pop();
                continue;
            }

            int female = femalesQueue.poll();

            if (female <= 0) {
                malesStack.push(male);
                continue;
            }
            if (female % 25 == 0) {
                female = femalesQueue.poll();
                malesStack.push(male);
                continue;
            }

            if (female == male) {
                matches++;
            } else {
                malesStack.push(male - 2);
            }
        }

        System.out.println("Matches: " + matches);

        if (!malesStack.isEmpty()) {
            System.out.print("Males left: ");

            System.out.println(String.join(" ",
                    malesStack.toString()
                            .replace("[", "")
                            .replace("]", "")));
        } else {
            System.out.println("Males left: none");
        }

        if (!femalesQueue.isEmpty()) {
            System.out.print("Females left: ");

            System.out.println(String.join(" ",
                    femalesQueue.toString()
                            .replace("[", "")
                            .replace("]", "")));
        } else {
            System.out.println("Females left: none");
        }
    }
}
