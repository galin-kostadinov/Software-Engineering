package Method;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {6};
        f(arr);
        System.out.println(arr[0]);
        //String result = String.join("",result);
    }

    static void f(int[] arr) {
        arr = new int[1];
        arr[0]++;
    }
}
