import java.util.function.Consumer;

public class BinaryTree<T> {
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T value) {
        this(value, null, null);
    }

    public BinaryTree(T value, BinaryTree<T> child) {
        this(value, child, null);
    }

    public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        this.value = value;
        this.left = leftChild;
        this.right = rightChild;
    }

    // append output to builder
    public String printIndentedPreOrder(int indent, StringBuilder builder) {
        this.printIndentedPreOrder(this, indent, builder);

        return builder.toString();
    }

    private void printIndentedPreOrder(BinaryTree<T> node, int indented, StringBuilder builder) {
        builder.append(" ".repeat(indented)).append(node.value).append(System.lineSeparator());

        if (node.left != null) {
            this.printIndentedPreOrder(node.left, indented + 2, builder);
        }

        if (node.right != null) {
            this.printIndentedPreOrder(node.right, indented + 2, builder);
        }
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this, consumer);
    }

    public void eachInOrder(BinaryTree<T> node, Consumer<T> consumer) {
        if (node.left != null) {
            this.eachInOrder(node.left, consumer);
        }

        consumer.accept(node.value);

        if (node.right != null) {
            this.eachInOrder(node.right, consumer);
        }
    }

    public void eachPostOrder(Consumer<T> consumer) {
        this.eachPostOrder(this, consumer);
    }

    public void eachPostOrder(BinaryTree<T> node, Consumer<T> consumer) {
        if (node.left != null) {
            this.eachPostOrder(node.left, consumer);
        }

        if (node.right != null) {
            this.eachPostOrder(node.right, consumer);
        }

        consumer.accept(node.value);
    }
}
