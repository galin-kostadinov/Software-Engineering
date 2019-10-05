import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);W
        stack.push(4);
        stack.push(5);

        System.out.println(Arrays.toString(stack.toArray()));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
