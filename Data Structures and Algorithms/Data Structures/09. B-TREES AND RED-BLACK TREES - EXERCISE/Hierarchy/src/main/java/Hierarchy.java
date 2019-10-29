import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {
    private Node root;
    private Map<T, Node> nodesByValue;

    public Hierarchy(T element) {
        this.root = new Node(element);
        this.nodesByValue = new LinkedHashMap<>();
        this.nodesByValue.putIfAbsent(element, this.root);
    }

    public void add(T parent, T child) {
        if (!this.nodesByValue.containsKey(parent)) {
            throw new IllegalArgumentException();
        }

        if (this.nodesByValue.containsKey(child)) {
            throw new IllegalArgumentException();
        }

        Node parentNode = this.nodesByValue.get(parent);
        Node childNode = new Node(child, parentNode);

        parentNode.children.add(childNode);
        this.nodesByValue.put(child, childNode);
    }

    public int getCount() {
        return this.nodesByValue.size();
    }

    public void remove(T element) {
        if (!this.nodesByValue.containsKey(element)) {
            throw new IllegalArgumentException();
        }

        Node current = this.nodesByValue.get(element);

        if (current.parent == null) {
            throw new IllegalStateException();
        }

        for (Node currentChild : current.children) {
            currentChild.parent = current.parent;
            current.parent.children.add(currentChild);
        }

        current.parent.children.remove(current);
        this.nodesByValue.remove(current.value);
    }

    public boolean contains(T element) {
        return this.nodesByValue.containsKey(element);
    }

    public T getParent(T element) {
        if (!this.nodesByValue.containsKey(element)) {
            throw new IllegalArgumentException();
        }

        Node child = this.nodesByValue.get(element);

        return child.getParent() != null ? child.getParent().getValue() : null;
    }

    public Iterable<T> getChildren(T element) {
        if (!this.nodesByValue.containsKey(element)) {
            throw new IllegalArgumentException();
        }

        Node parent = this.nodesByValue.get(element);

        return parent.children.stream().map(Node::getValue).collect(Collectors.toList());
    }

    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        List<T> collection = new ArrayList<>();
        for (Map.Entry<T, Node> kvp : this.nodesByValue.entrySet()) {
            if (other.contains(kvp.getKey())) {
                collection.add(kvp.getKey());
            }
        }

        return collection;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayDeque<Node> queue = new ArrayDeque<>();

        Node current = this.root;
        queue.offer(current);

        Iterator hierarchyIterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Object next() {
                Node current = queue.poll();

                for (Node child : current.children) {
                    queue.offer(child);
                }

                return current.value;
            }
        };

        return hierarchyIterator;
    }

    private class Node {
        private Node parent;
        private T value;
        private List<Node> children;

        public Node(T value, Node parent) {
            this.value = value;
            this.children = new ArrayList<>();
            this.parent = parent;
        }

        public Node(T value) {
            this(value, null);
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
