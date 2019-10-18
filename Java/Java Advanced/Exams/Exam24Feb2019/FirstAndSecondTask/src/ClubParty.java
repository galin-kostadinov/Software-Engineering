import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int hallCapacity = Integer.parseInt(reader.readLine());
        if (hallCapacity <= 0) {
            return;
        }

        ArrayDeque<String> inputStack = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s++")).forEach(inputStack::push);

        ArrayDeque<Pair> hallsQueue = new ArrayDeque<>();

        while (!inputStack.isEmpty()) {
            String currentElement = inputStack.pop();

            if (Character.isLetter(currentElement.charAt(0))) {
                hallsQueue.offer(new Pair(currentElement));
            } else if (!hallsQueue.isEmpty()) {
                int currentGroup = Integer.parseInt(currentElement);

                if (currentGroup > hallCapacity || currentGroup == 0) {
                    continue;
                }

                int sumPeople = currentGroup + hallsQueue.peek().getSum();

                if (sumPeople <= hallCapacity) {
                    hallsQueue.peek().addGroup(currentGroup);
                } else if (hallsQueue.size() > 1) {
                    hallsQueue.poll().print();
                    hallsQueue.peek().addGroup(currentGroup);
                } else {
                    hallsQueue.poll().print();
                }
            }
        }
    }

    static class Pair {
        private String name;
        private List<Integer> people;
        private int sum;

        public Pair(String name) {
            this.name = name;
            this.people = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addGroup(int currentGroup) {
            this.people.add(currentGroup);
            this.sum += currentGroup;
        }

        public int getSum() {
            return this.sum;
        }

        public void print() {
            System.out.print(this.getName() + " -> ");
            System.out.print(String.join(", ",
                    people.toString().replace("[", "").replace("]", "")));
            System.out.println();
        }
    }
}
