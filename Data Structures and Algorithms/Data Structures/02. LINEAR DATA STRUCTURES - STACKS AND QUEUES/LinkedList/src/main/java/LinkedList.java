import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    private Node head;
    private Node tail;

    private int size;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
        Node oldHead = this.head;

        this.head = new Node(item);

        this.head.next = oldHead;

        if (this.size == 0) {
            this.tail = this.head;
        }

        this.size++;
    }

    public void addLast(E item) {
        Node oldTail = this.tail;

        this.tail = new Node(item);

        if (this.size == 0) {
            this.head = this.tail;
        } else {
            oldTail.next = this.tail;
        }

        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new UnsupportedOperationException();
        }

        Node oldHead = this.head;
        this.head = this.head.next;
        this.size--;

        if (this.size == 0) {
            this.tail = null;
        }

        return oldHead.value;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new UnsupportedOperationException();
        }

        Node oldTail = this.tail;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node newTail = this.GetSecondToLastNode();
            newTail.next = null;
            this.tail = newTail;
        }
        this.size--;
        return oldTail.value;
    }

    private Node GetSecondToLastNode() {
        Node current = this.head;
        while (current.next != this.tail) {
            current = current.next;
        }

        return current;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node currentNode = head;

            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }

            @Override
            public E next() {
                E value = this.currentNode.value;
                this.currentNode = this.currentNode.next;
                return value;
            }
        };
    }

    private class Node {
        private E value;
        private Node next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }
}
