import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuadTree<T extends Boundable> {

    public static final int DEFAULT_MAX_DEPTH = 5;

    private int maxDepth;

    private Node<T> root;

    private Rectangle bounds;

    private int count;

    public QuadTree(int width, int height) {
        this(width, height, DEFAULT_MAX_DEPTH);
    }

    public QuadTree(int width, int height, int maxDepth) {
        this.root = new Node<T>(0, 0, width, height);
        this.bounds = this.root.getBounds();
        this.maxDepth = maxDepth;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    private void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getCount() {
        return this.count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public boolean insert(T item) {
        if (!item.getBounds().isInside(bounds)) {
            return false;
        }

        var depth = 1;
        var currNode = this.root;

        while (currNode.getChildren() != null) {
            var quadrant = GetQuadrant(currNode, item.getBounds());

            if (quadrant == -1) {
                break;
            }

            currNode = currNode.getChildren()[quadrant];
            depth++;
        }

        currNode.getItems().add(item);

        trySplitNode(currNode, depth);

        this.count++;

        return true;
    }

    private void trySplitNode(Node<T> node, int depth) {
        if (!(node.shouldSplit() && depth < maxDepth)) {
            return;
        }

        int x1 = node.getBounds().getX1();
        int y1 = node.getBounds().getY1();
        int leftWidth = node.getBounds().getWidth() / 2;
        int rightWidth = node.getBounds().getWidth() - leftWidth;
        int upperHeight = node.getBounds().getHeight() / 2;
        int lowerHeight = node.getBounds().getHeight() - upperHeight;

        if (node.getChildren() == null) {
            Node<T>[] children = new Node[4];

            // upperRight
            children[0] = new Node(node.getBounds().getMidX(), y1, rightWidth, upperHeight);
            // upperLeft
            children[1] = new Node(x1, y1, leftWidth, upperHeight);
            // lowerLeft
            children[2] = new Node(x1, node.getBounds().getMidY(), leftWidth, lowerHeight);
            // lowerRight
            children[3] = new Node(node.getBounds().getMidX(), node.getBounds().getMidY(), rightWidth, lowerHeight);

            node.setChildren(children);
        }

        for (int i = 0; i < node.getItems().size(); ) {
            T item = node.getItems().get(i);
            int quadrant = GetQuadrant(node, item.getBounds());
            if (quadrant != -1) {
                node.getItems().remove(item);
                node.getChildren()[quadrant].getItems().add(item);
            } else {
                i++;
            }
        }

        for (var child : node.getChildren()) {
            trySplitNode(child, depth + 1);
        }
    }

    private int GetQuadrant(Node<T> node, Rectangle itemBound) {
        if (node.getChildren() == null) {
            return -1;
        }

        for (int i = 0; i < 4; i++) {
            Rectangle nodeBounds = node.getChildren()[i].getBounds();
            if (itemBound.isInside(nodeBounds)) return i;
        }

        return -1;
    }

    public List<T> report(Rectangle bounds) {
        List<T> result = new LinkedList<>();

        this.reportCollision(this.root, result, bounds);

        return result;
    }

    private void reportCollision(Node<T> node, List<T> result, Rectangle bounds) {
        int quadrant = this.GetQuadrant(node, bounds);

        if (quadrant == -1) {
            getSubtreeContents(node, result, bounds);
        } else {
            if (node.getChildren() != null) {
                for (var child : node.getChildren()) {
                    if (bounds.isInside(child.getBounds())) {
                        reportCollision(child, result, bounds);
                    }
                }
            }

            result.addAll(node.getItems());
        }
    }

    private void getSubtreeContents(Node<T> node, List<T> result, Rectangle bounds) {
        if (node.getChildren() != null) {
            for (var child : node.getChildren()) {
                if (child.getBounds().intersects(bounds)) {
                    getSubtreeContents(child, result, bounds);
                }
            }
        }

        result.addAll(node.getItems());
    }
}
