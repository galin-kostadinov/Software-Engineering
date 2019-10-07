import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(Arrays.toString(stack.toArray()));

        Integer element = stack.pop();
        Integer element1 = stack.pop();
        Integer element2 = stack.pop();
        Integer element3 = stack.pop();

        System.out.println(element);
        System.out.println(element1);
        System.out.println(element2);
        System.out.println(element3);

        Integer elementNull = stack.pop();
    }
}
