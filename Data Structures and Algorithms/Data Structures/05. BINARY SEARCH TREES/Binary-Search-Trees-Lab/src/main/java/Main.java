import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(20);
        bst.insert(16);
        bst.insert(17);
        bst.insert(18);
        bst.insert(28);
        bst.insert(14);
        bst.insert(29);
        bst.insert(3);

        for (Integer number : bst.range(3, 17)) {
            System.out.println(number);
        }
        System.out.println();
    }
}
