import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class MakeSalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> saladsToMakeStack = new ArrayDeque<>();
        ArrayDeque<Integer> readySaladsQueue = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s++")).forEach(productsQueue::offer);
        Arrays.stream(reader.readLine().split("\\s++")).forEach(s -> saladsToMakeStack.push(Integer.parseInt(s)));

        while (!productsQueue.isEmpty() && !saladsToMakeStack.isEmpty()) {
            int saladCalories = saladsToMakeStack.pop();

            int currCalories = 0;
            while (!productsQueue.isEmpty()) {
                String currProduct = productsQueue.poll();

                switch (currProduct) {
                    case "tomato":
                        currCalories += 80;
                        break;
                    case "carrot":
                        currCalories += 136;
                        break;
                    case "lettuce":
                        currCalories += 109;
                        break;
                    case "potato":
                        currCalories += 215;
                        break;
                    default:
                        break;
                }

                if (currCalories >= saladCalories) {
                    readySaladsQueue.offer(saladCalories);
                    break;
                } else if (productsQueue.isEmpty()) {
                    readySaladsQueue.offer(saladCalories);
                }
            }
        }

        if (!readySaladsQueue.isEmpty()) {
            System.out.println(String.join(" ",
                    readySaladsQueue.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", "")));
        }

        if (!productsQueue.isEmpty()) {
            System.out.println(String.join(" ",
                    productsQueue.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", "")));
        }

        if (!saladsToMakeStack.isEmpty()) {
            System.out.println(String.join(" ",
                    saladsToMakeStack.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", "")));
        }
    }
}
