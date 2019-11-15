import java.util.function.Consumer;

public class KdTree {

    public class Node {

        private Point2D point2D;
        private Node left;
        private Node right;

        public Node(Point2D point) {
            this.setPoint2D(point);
        }

        public Point2D getPoint2D() {
            return this.point2D;
        }

        public void setPoint2D(Point2D point2D) {
            this.point2D = point2D;
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

    private final int kD = 2; //2D
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public boolean contains(Point2D point) {
        if (this.root == null) {
            return false;
        }

        return contains(this.root, point, 0);
    }

    private boolean contains(Node node, Point2D point, int depth) {
        if (node == null) {
            return false;
        }

        if (node.point2D.getX() == point.getX() && node.point2D.getY() == point.getY()) {
            return true;
        }

        int compare = depth % kD;

        if (compare == 0) {
            if (node.point2D.getX() - point.getX() > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        } else {
            if (node.point2D.getY() - point.getY() > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return contains(node, point, depth + 1);
    }

    public void insert(Point2D point) {
        this.root = this.insert(this.root, point, 0);
    }

    private Node insert(Node node, Point2D point, int depth) {
        if (node == null) {
            return new Node(point);
        }

        int compare = depth % kD;

        if (compare == 0) {
            if (node.point2D.getX() - point.getX() > 0) {
                node.left = this.insert(node.left, point, depth + 1);
            } else {
                node.right = this.insert(node.right, point, depth + 1);
            }
        } else {
            if (node.point2D.getY() - point.getY() > 0) {
                node.left = this.insert(node.left, point, depth + 1);
            } else {
                node.right = this.insert(node.right, point, depth + 1);
            }
        }

        return node;
    }

    public void eachInOrder(Consumer<Point2D> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<Point2D> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.getLeft(), consumer);
        consumer.accept(node.getPoint2D());
        this.eachInOrder(node.getRight(), consumer);
    }
}
