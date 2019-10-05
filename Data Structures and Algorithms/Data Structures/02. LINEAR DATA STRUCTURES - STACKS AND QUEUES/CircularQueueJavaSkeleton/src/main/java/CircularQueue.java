public class CircularQueue<E> {
    private final int defaultCapacity = 4;
    private int capacity;
    private int size;
    private int head;
    private int tail;
    private E[] array;

    public CircularQueue() {
        this.array = (E[]) new Object[defaultCapacity];
        this.capacity = defaultCapacity;
    }

    public CircularQueue(int initialCapacity) {
        this.array = (E[]) new Object[initialCapacity];
        this.capacity = initialCapacity;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(E element) {
        if (this.capacity <= this.size) {
            this.resize();
        }

        this.array[this.tail] = element;
        this.tail = (this.tail + 1) % this.capacity;
        this.size++;
    }

    private void resize() {
        this.capacity *= 2;
        E[] newArray = (E[]) new Object[this.capacity];

        this.copyAllElements(newArray);

        this.array = newArray;
        this.head = 0;
        this.tail = this.size;
    }

    private void copyAllElements(E[] newArray) {
        int currentIndex = 0;
        int currentHead = this.head;

        int oldCapacity = this.array.length;
        while (currentIndex < this.size) {
            newArray[currentIndex++] = this.array[currentHead];
            currentHead = (currentHead + 1) % oldCapacity;
        }
    }

    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        E result = this.array[this.head];
        this.head = (this.head + 1) % this.capacity;
        this.size--;

        return result;
    }

    public E[] toArray() {
        E[] newArray = (E[]) new Object[this.size];

        this.copyAllElements(newArray);

        return newArray;
    }
}
