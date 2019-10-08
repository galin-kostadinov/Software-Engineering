public class LinkedQueue<E> {

    private int size;
    private QueueNode<E> head;
    private QueueNode<E> tail;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        QueueNode<E> newNode = new QueueNode<>();

        if (this.head == null) {
            this.head = newNode;
            this.head.value = element;
            this.tail = this.head;
        } else {
            newNode.value = element;
            newNode.prevNode = this.tail;

            this.tail.nextNode = newNode;
            this.tail = newNode;
        }

        this.setSize(this.size + 1);
    }

    public E dequeue() {
        if (this.size == 0) {
            throw new IllegalArgumentException("Queue is Empty!");
        }

        E value = this.head.value;

        this.head = this.head.nextNode;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prevNode = null;
        }

        this.setSize(this.size - 1);

        return value;
    }

    public E[] toArray() {
        E[] array = (E[]) new Object[this.size];

        QueueNode<E> currHead = this.head;
        for (int i = 0; i < this.size; i++) {
            array[i] = currHead.value;

            currHead = currHead.nextNode;
        }

        return array;
    }

    private class QueueNode<E> {
        private E value;

        private QueueNode<E> nextNode;
        private QueueNode<E> prevNode;

    }
}