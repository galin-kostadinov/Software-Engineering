public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Integer[] integers = stack.toArray(Integer.class);

        for (Object integer : integers) {
            System.out.print(integer + " ");
        }

        System.out.println();

        while (stack.peek() != null) {
            System.out.println(stack.pop());
        }
    }
}
