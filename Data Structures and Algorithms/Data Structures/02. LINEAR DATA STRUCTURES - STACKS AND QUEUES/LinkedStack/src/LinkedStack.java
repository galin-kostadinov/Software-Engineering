import java.lang.reflect.Array;
import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T> {
    private int count;
    private StackNode<T> top;

    public void push(T element) {
        this.top = new StackNode<>(element, this.top);
        count++;
    }

    public T pop() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }

        T result = this.top.value;
        this.top = this.top.next;
        count--;

        return result;
    }

    public T peek() {
        if (count == 0) {
            return null;
        }
        return this.top.value;
    }

    public T[] toArray(Class<T> tClass) {
        int size = this.count;
        T[] array = (T[]) Array.newInstance(tClass, size);

        int index = 0;
        StackNode<T> currTop = this.top;

        while (currTop != null) {
            array[index++] = currTop.value;
            currTop = currTop.next;
        }

        return array;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    static class StackNode<T> {
        private T value;
        private StackNode<T> next;

        StackNode(T value, StackNode<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
