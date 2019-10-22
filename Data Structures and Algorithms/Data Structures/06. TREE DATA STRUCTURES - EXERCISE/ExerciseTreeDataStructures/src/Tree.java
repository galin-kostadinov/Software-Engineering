import java.util.*;
import java.util.stream.Collectors;

class Tree<T> implements Iterable<T> {
    private T value;
    private List<Tree<T>> children;
    private Tree<T> parent;

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public void addChild(Tree<T> children) {
        this.children.add(children);
    }

    public Tree<T> getParent() {
        return parent;
    }

    public void setParent(Tree<T> parent) {
        this.parent = parent;
    }

    public List<Tree<T>> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    public T getNodeValue() {
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
