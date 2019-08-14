public class Main {
    public static void main(String[] args) {

        DoublyLinkedList testList = new DoublyLinkedList();

        testList.addLast(1);
        testList.addLast(2);
        testList.addLast(3);
        testList.addFirst(-1);

        testList.removeFirst();

        testList.removeLast();

        int[] arr = testList.toArray();

        testList.forEach(System.out::println);
        System.out.println();
        System.out.println(testList.get(0));
    }
}
