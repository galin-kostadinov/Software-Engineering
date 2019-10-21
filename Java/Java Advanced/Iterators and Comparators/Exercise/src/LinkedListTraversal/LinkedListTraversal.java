package LinkedListTraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedListTraversal implements Iterable {
    private class ListNode {
        private int item;
        private ListNode next;
        private ListNode previous;

        private ListNode(int item) {
            this.item = item;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    int getSize() {
        return this.size;
    }

    public void add(Integer element) {
        ListNode newTail = new ListNode(element);

        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.previous = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }

        this.size++;
    }

    public boolean remove(int element) {
        checkSize();

        ListNode currentNode = this.head;

        for (int i = 0; i < this.size; i++) {
            int value = currentNode.item;

            if (value == element) {
                ListNode prev = currentNode.previous;
                ListNode next = currentNode.next;

                if (prev == null) {
                    this.head = next;
                } else {
                    prev.next = next;
                }

                if (next == null) {
                    tail = prev;
                } else {
                    next.previous = prev;
                }

                this.size--;

                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    private void checkSize() {
        if (this.size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index: %d, Size: %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Integer>() {
            private ListNode currentNode = head;

            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }

            @Override
            public Integer next() {
                int value = this.currentNode.item;
                this.currentNode = this.currentNode.next;
                return value;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        ListNode currentNode = this.head;

        while (currentNode != null) {
            action.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }
}
