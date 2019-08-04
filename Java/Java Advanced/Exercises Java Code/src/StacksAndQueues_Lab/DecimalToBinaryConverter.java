package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(sc.nextLine());

        if (decimalNumber == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        while (decimalNumber != 0) {
            binaryNumber.push(decimalNumber % 2);
            decimalNumber /= 2;
        }

        while (!binaryNumber.isEmpty()) {
            System.out.printf("%d", binaryNumber.pop());
        }
        System.out.println();
    }
}
