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
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public CircularQueue(int initialCapacity) {
        this.array = (E[]) new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(E element) {
        if (tail == 0 && head == 0 && size == 0) {
            array[head] = element;
            tail++;
            this.size++;
        } else if (tail < capacity && tail + 1 != head && size < capacity) {
            array[tail] = element;
            tail++;
            this.size++;
        } else if (tail == capacity && head > 0) {
            tail = 0;
            array[tail] = element;
            tail++;
            this.size++;
        } else if (size >= capacity && head < tail) {
            int oldCapacity = this.capacity;
            this.capacity = 2 * oldCapacity;
            E[] newArray = (E[]) new Object[this.capacity];

            for (int i = 0; i < oldCapacity; i++) {
                newArray[i] = this.array[i];
            }

            this.array = newArray;
            this.array[tail] = element;

            this.tail++;
            this.size++;
        } else if (size >= capacity && head >= tail) {
            E[] newArray = this.toArray();
            this.array = newArray;

            int oldCapacity = this.capacity;
            this.capacity = 2 * oldCapacity;

            newArray = (E[]) new Object[this.capacity];
            for (int i = 0; i < oldCapacity; i++) {
                newArray[i] = this.array[i];
            }

            this.array = newArray;
            this.head = 0;
            this.tail = this.size;

            this.array[tail] = element;

            this.tail++;
            this.size++;
        } else if (head >= tail && size < capacity) {
            array[tail] = element;
            tail++;
            this.size++;
        }
    }

    public E dequeue() {
        E element;
        if (size == 0) {
            throw new IllegalArgumentException();
        } else if (head == capacity) {
            head = 0;
            element = this.array[head];
            head++;
            size--;
        } else {
            element = this.array[head];
            head++;
            size--;
        }

        return element;
    }

    public E[] toArray() {
        E[] newArray = (E[]) new Object[this.size];
        int currentTail = this.tail;
        int currentHead = this.head;

        for (int i = 0; i < this.size; i++) {
            if (currentTail > currentHead) {
                newArray[i] = this.array[currentHead];
                currentHead++;
            } else if (currentHead > currentTail && currentHead < this.capacity || currentHead == currentTail) {
                newArray[i] = this.array[currentHead];
                currentHead++;
            } else if (currentHead == this.capacity) {
                currentHead = 0;
                newArray[i] = this.array[currentHead];
                currentHead++;
            } else {
                newArray[i] = this.array[currentHead];
                currentHead++;
            }
        }

        return newArray;
    }
}
