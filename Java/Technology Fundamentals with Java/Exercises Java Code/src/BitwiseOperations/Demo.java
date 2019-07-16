package BitwiseOperations;

public class Demo {
    public static void main(String[] args) {

        int num = 24;
        int shiftedValue = num >> 1;
        if ((shiftedValue & 1) == 1) {
            System.out.println("odd");
        } else {
            System.out.println("even");
        }
    }
}
