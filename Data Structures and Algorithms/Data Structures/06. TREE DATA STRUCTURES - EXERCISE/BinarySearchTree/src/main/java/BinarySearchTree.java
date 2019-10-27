import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    private int nodesCount;

    public BinarySearchTree() {
    }

    private BinarySearchTree(Node root) {
        this.preOrderCopy(root);
    }

    private void preOrderCopy(Node node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.preOrderCopy(node.left);
        this.preOrderCopy(node.right);
    }

    public Node getRoot() {
        return this.root;
    }

    public int getNodesCount() {
        return this.nodesCount;
    }

    public void insert(T value) {
        this.nodesCount++;

        if (this.root == null) {
            this.root = new Node(value);
            return;
        }

        Node parent = null;
        Node current = this.root;
        while (current != null) {
            parent = current;
            parent.childrenCount++;

            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return;
            }
        }

        Node newNode = new Node(value);
        if (value.compareTo(parent.value) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public boolean contains(T value) {
        Node current = this.root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return current != null;
    }

    public BinarySearchTree<T> search(T item) {
        Node current = this.root;
        while (current != null) {
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }

        return new BinarySearchTree<>(current);
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public Iterable<T> range(T from, T to) {
        Deque<T> queue = new LinkedList<>();
        this.range(this.root, queue, from, to);
        return queue;
    }

    private void range(Node node, Deque<T> queue, T startRange, T endRange) {
        if (node == null) {
            return;
        }

        int compareStart = startRange.compareTo(node.value);
        int compareEnd = endRange.compareTo(node.value);
        if (compareStart < 0) {
            this.range(node.left, queue, startRange, endRange);
        }
        if (compareStart <= 0 && compareEnd >= 0) {
            queue.addLast(node.value);
        }
        if (compareEnd > 0) {
            this.range(node.right, queue, startRange, endRange);
        }
    }

    private T minValue(Node root) {
        T minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }

        return minv;
    }

    public void deleteMin() {
        if (this.root == null) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        Node min = this.root;
        Node parent = null;

        while (min.left != null) {
            parent = min;
            parent.childrenCount--;
            min = min.left;
        }

        if (parent == null) {
            this.root = this.root.right;
        } else {
            parent.left = min.right;
        }

        this.nodesCount--;
    }

    public void deleteMax() {
        if (this.root == null) {
            throw new IllegalArgumentException("Tree is empty!");
        }

        this.root = this.deleteMax(this.root);
        this.nodesCount--;
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            node.decreaseChildrenCount();
            return node.left;
        }

        node.right = this.deleteMax(node.right);

        return node;
    }

    public int count() {
        return this.count(this.root);
    }

    public int count(Node node) {
        if (node == null) {
            return 0;
        }

        return node.getChildrenCount();
    }

    public T ceil(T element) {
        try {
            return this.select(this.rank(element));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public T floor(T element) {
        try {
            return this.select(this.rank(element) - 1);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public void delete(T key) {
//        if (this.count(this.root) == 0 || !this.contains(key)) {
//            throw new IllegalArgumentException();
//        }

        this.root = this.delete(this.root, key);
    }

    private Node delete(Node node, T element) {
        if (node == null) {
            return null;
        }

        int compare = node.getValue().compareTo(element);

        if (compare > 0) {
            node.left = delete(node.left, element);
        } else if (compare < 0) {
            node.right = delete(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node leftMost = this.subtreeLeftmost(node.right);

            node.value = leftMost.value;
            node.right = this.delete(node.right, leftMost.value);
        }

        node.decreaseChildrenCount();
        return node;
    }

    private Node subtreeLeftmost(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public int rank(T item) {
        return this.rank(this.root, item);
    }

    private int rank(Node node, T item) {
        if (node == null) {
            return 0;
        }

        int compare = node.getValue().compareTo(item);

        if (compare > 0) {
            return this.rank(node.left, item);
        } else if (compare < 0) {
            return 1 + this.count(node.left) + this.rank(node.right, item);
        }

        return this.count(node.left);
    }

    public T select(int rank) {
        Node node = this.select(this.root, rank);

        if (node == null) {
            throw new IllegalArgumentException();
        }

        return node.value;

    }

    public Node select(Node node, int rank) {
        if (node == null) {
            return null;
        }

        int leftCount = this.count(node.left);

        if (Integer.compare(leftCount, rank) > 0) {
            return this.select(node.left, rank);
        } else if (Integer.compare(leftCount, rank) < 0) {
            return this.select(node.right, rank - (leftCount + 1));
        }

        return node;
    }

    class Node {
        private T value;
        private Node left;
        private Node right;

        private int childrenCount;

        public Node(T value) {
            this.value = value;
            this.childrenCount = 1;
        }

        public int getChildrenCount() {
            return childrenCount;
        }

        public void decreaseChildrenCount() {
            this.childrenCount--;
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

        @Override
        public String toString() {
            return this.value + "";
        }
    }
}

