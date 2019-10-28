import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {
    private List<T> heap;

    public BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    public int size() {
        return this.heap.size();
    }

    public void insert(T element) {
        this.heap.add(element);
        this.heapifyUp(this.heap.size() - 1);
    }

    private void heapifyUp(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        T parent = this.heap.get(parentIndex);
        int compare = parent.compareTo(this.heap.get(childIndex));

        if (compare < 0) {
            this.swap(parentIndex, childIndex);
            this.heapifyUp(parentIndex);
        }
    }

    private void swap(int parentIndex, int childIndex) {
        T parent = this.heap.get(parentIndex);
        T child = this.heap.get(childIndex);

        this.heap.set(parentIndex, child);
        this.heap.set(childIndex, parent);
    }

    public T peek() {
        if (this.size() > 0) {
            return this.heap.get(0);
        } else {
            throw new IllegalArgumentException("Heap is empty");
        }
    }

    public T pull() {
        if (this.size() > 0) {
            T element = this.heap.get(0);
            this.swap(0, this.size() - 1);
            this.heap.remove(this.size() - 1);
            this.heapifyDown(0);

            return element;
        } else {
            throw new IllegalArgumentException("Heap is empty");
        }
    }

    private void heapifyDown(int index) {
        int parentIndex = index;
        while (parentIndex < this.size() / 2) {
            int childIndex = (parentIndex * 2) + 1;

            if (childIndex + 1 < this.size() && isGreater(childIndex, childIndex + 1)) {
                childIndex += 1;
            }

            int compare = this.heap.get(parentIndex).compareTo(this.heap.get(childIndex));
            if (compare < 0) {
                this.swap(childIndex, parentIndex);
            }
            parentIndex = childIndex;
        }
    }

    private boolean isGreater(int left, int right) {
        return this.heap.get(left).compareTo(this.heap.get(right)) < 0;
    }
}
