public class Main {
    public static void main(String[] args) {
        Node<Integer> firstNode = new Node<>(5);
        Node<Integer> secondNode = new Node<>(10);
        Node<Integer> thirdNode = new Node<>(-1);
        firstNode.setNext(secondNode);
        secondNode.setNext(thirdNode);
        Node<Integer> current = firstNode;

        while(current!=null){
            System.out.println(current.getValue());
            current = current.getNext();
        }

    }
}
