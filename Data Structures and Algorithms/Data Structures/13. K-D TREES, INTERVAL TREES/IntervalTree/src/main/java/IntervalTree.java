import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IntervalTree {

    private class Node {

        private Interval interval;
        private double max;
        private Node right;
        private Node left;

        public Node(Interval interval) {
            this.interval = interval;
            this.max = interval.getHi();
        }
    }

    private Node root;

    public void insert(double lo, double hi) {
        this.root = this.insert(this.root, lo, hi);
    }

    public void eachInOrder(Consumer<Interval> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    public Interval searchAny(double lo, double hi) {
        Node current = this.root;

        while (current != null && !current.interval.intersects(lo, hi)) {
            if (current.left != null && current.left.max > lo) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return null;
        }

        return current.interval;
    }

    public Iterable<Interval> searchAll(double lo, double hi) {
        List<Interval> result = new ArrayList<>();

        if (this.root == null) {
            return result;
        }

        this.searchAll(this.root, result, new Interval(lo, hi));

        return result;
    }

    private void searchAll(Node node, List<Interval> result, Interval i) {
        if (node.left != null && node.left.max > i.getLo()) {
            this.searchAll(node.left, result, i);
        }

        if (node.interval.intersects(i)) {
            result.add(node.interval);
        }

        if (node.right != null && node.right.interval.getLo() < i.getHi()) {
            this.searchAll(node.right, result, i);
        }
    }

    private void eachInOrder(Node node, Consumer<Interval> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.interval);
        this.eachInOrder(node.right, consumer);
    }

    private Node insert(Node node, double lo, double hi) {
        if (node == null) {
            return new Node(new Interval(lo, hi));
        }

        int cmp = Double.compare(lo, node.interval.getLo());
        if (cmp < 0) {
            node.left = insert(node.left, lo, hi);
        } else if (cmp > 0) {
            node.right = insert(node.right, lo, hi);
        }

        this.updateMax(node);

        return node;
    }

    private void updateMax(Node node) {
        double max = Math.max(this.getMax(node.left), this.getMax(node.right));
        node.max = Math.max(max, node.max);
    }

    private double getMax(Node node) {
        if (node == null) {
            return 0;
        }

        return node.max;
    }
}
