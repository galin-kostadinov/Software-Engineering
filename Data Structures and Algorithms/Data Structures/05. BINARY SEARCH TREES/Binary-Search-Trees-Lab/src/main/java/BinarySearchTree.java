import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private BinarySearchTree(Node node) {
        this.copy(node);
    }

    private void copy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.copy(node.left);
        this.copy(node.right);
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node parent = null;
        Node current = this.root;

        while (current != null) {

            int compare = current.value.compareTo(value);

            if (compare > 0) {
                parent = current;
                current = current.left;
            } else if (compare < 0) {
                parent = current;
                current = current.right;
            } else {
                return;
            }
        }

        Node newNode = new Node(value);

        if (parent.value.compareTo(value) > 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        // this.root = this.insert(this.root, value); //DFS
    }

    private Node insert(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }

        int compare = node.value.compareTo(value);

        if (compare > 0) {
            node.left = this.insert(node.left, value);
        } else if (compare < 0) {
            node.right = this.insert(node.right, value);
        }

        return node;
    }

    public boolean contains(T value) {
        Node current = this.root;

        while (current != null) {
            int compare = current.value.compareTo(value);

            if (compare > 0) {
                current = current.left;
            } else if (compare < 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;

        while (current != null) {
            int compare = current.value.compareTo(item);

            if (compare > 0) {
                current = current.left;
            } else if (compare < 0) {
                current = current.right;
            } else {
                return new BinarySearchTree<T>(current);
            }
        }

        return new BinarySearchTree<T>();
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    public void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public void deleteMin() {
        if (this.root == null) {
            return;
        }

        if (this.root.left == null && this.root.right == null) {
            this.root = null;
            return;
        }

        Node parent = null;
        Node current = this.root;

        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        if (current.right != null) {
            parent.left = current.right;
        } else {
            parent.left = null;
        }
    }

    public Iterable<T> range(T from, T to) {
        List<T> result = new ArrayList<>();

        this.range(this.root, result, from, to);

        return result;
    }

    private void range(Node node, List<T> result, T start, T end) {
        if (node == null) {
            return;
        }

        int compareLow = node.value.compareTo(start);
        int compareHigh = node.value.compareTo(end);

        if (compareLow > 0) {
            this.range(node.left, result, start, end);
        }

        if (compareLow >= 0 && compareHigh <= 0) {
            result.add(node.value);
        }

        if (compareHigh < 0) {
            this.range(node.right, result, start, end);
        }
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
