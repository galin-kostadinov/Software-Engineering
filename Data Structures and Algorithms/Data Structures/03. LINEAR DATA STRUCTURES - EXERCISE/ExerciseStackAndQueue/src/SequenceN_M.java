import java.util.*;

public class SequenceN_M {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        if (end < start) {
            return;
        }

        ArrayDeque<Item> queue = new ArrayDeque<>();

        Item startItem = new Item(start);

        queue.offer(startItem);

        while (true) {
            Item element = queue.poll();

            if (element != null && element.value == end) {
                System.out.println(element.toString());
                break;
            }

            queue.offer(new Item(element.value + 1, element));
            queue.offer(new Item(element.value + 2, element));
            queue.offer(new Item(element.value * 2, element));
        }
    }

    private static class Item {
        private int value;
        private Item prevItem;

        public Item(int value) {
            this(value, null);
        }

        public Item(int value, Item prevItem) {
            this.setValue(value);
            this.setPrevItem(prevItem);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Item getPrevItem() {
            return prevItem;
        }

        public void setPrevItem(Item prevItem) {
            this.prevItem = prevItem;
        }

        public Integer[] toArray() {
            Stack<Integer> stack = new Stack<>();
            Item currentItem = this;

            while (currentItem != null) {
                stack.push(currentItem.getValue());
                currentItem = currentItem.getPrevItem();
            }

            Integer[] array = new Integer[stack.size()];
            int index = 0;
            while (!stack.isEmpty()) {
                array[index++] = stack.pop();
            }
            return array;
        }

        @Override
        public String toString() {
            return Arrays.toString(this.toArray())
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", " -> ");
        }
    }
}
