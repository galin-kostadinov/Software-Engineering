public class ArrayStack<T> {

    private static final int INITIAL_CAPACITY = 16;

    private T[] elements;
    private int size;

    public ArrayStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(T element) {
        if (this.size >= this.elements.length) {
            this.grow();
        }

        int index = this.size;
        this.elements[index] = element;
        this.setSize(this.size + 1);
    }

    public T pop() {
        if (this.size == 0) {
            throw new IllegalArgumentException("Stack is Empty!");
        }

        int index = this.size - 1;
        this.setSize(this.size - 1);
        return this.elements[index];
    }

    public T[] toArray() {
        T[] toReturn = (T[]) new Object[this.size];

        int index = 0;
        for (int i = this.size - 1; i >= 0; i--) {
            toReturn[index++] = this.elements[i];
        }

        return toReturn;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[this.size * 2];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.elements[i];
        }

        this.elements = newArray;
    }
}