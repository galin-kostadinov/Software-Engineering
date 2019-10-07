public class LinkedStack<E> {

    private Node<E> firstNode;
    private int size;


    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.size == 0) {
            this.firstNode = newNode;
        } else {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }

        setSize(this.size + 1);
    }

    public E pop() {
        if (this.size == 0) {
            throw new IllegalArgumentException("Stack is Empty!");
        } else {
            E value = firstNode.value;

            firstNode.value = null;
            firstNode = firstNode.nextNode;

            setSize(this.size - 1);

            return value;
        }
    }

    public E[] toArray() {
        E[] array = (E[]) new Object[this.size];

        Node<E> currFirstNode = this.firstNode;

        for (int i = 0; i < this.size; i++) {
            array[i] = currFirstNode.value;

            currFirstNode = currFirstNode.nextNode;
        }

        return array;
    }

    private class Node<E> {

        private E value;
        private Node<E> nextNode;

        public Node(E value) {
            this.value = value;
            this.nextNode = null;
        }

        public Node(E value, Node<E> nextNode) {
            this.value = value;
            this.setNextNode(nextNode);
        }

        public Node<E> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }
}