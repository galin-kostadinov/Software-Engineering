import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {
    public T value;
    public List<Tree<T>> children;


    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    // append output to builder
    public String print(int indent, StringBuilder builder) {
        builder.append(" ".repeat(indent)).append(this.value).append(System.lineSeparator());

        for (Tree<T> child : children) {
            child.print(indent + 2, builder);
        }

        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(this.value);

        for (Tree<T> child : this.children) {
            child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {
        List<T> result = new ArrayList<>();
        Stack<Tree<T>> stack = new Stack<>();

        stack.push(this);

        while (!stack.isEmpty()) {
            Tree<T> current = stack.pop();

            for (Tree<T> child : current.children) {
                stack.push(child);
            }

            result.add(current.value);
        }

        Collections.reverse(result);

        return result;
    }

//    private void DFS(Tree<T> node, List<T> result) {
//        for (Tree<T> child : node.children) {
//            this.DFS(child, result);
//        }
//
//        result.add(node.value);
//    }

    public Iterable<T> orderBFS() {
        List<T> result = new ArrayList<>();
        ArrayDeque<Tree<T>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<T> current = queue.poll();

            result.add(current.value);

            for (Tree<T> child : current.children) {
                queue.offer(child);
            }
        }

        return result;
    }
}