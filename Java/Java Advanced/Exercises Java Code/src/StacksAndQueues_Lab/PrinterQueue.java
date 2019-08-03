package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // printingQueue.poll(), printingQueue.offer(), printingQueue.peek();
        ArrayDeque<String> printingQueue = new ArrayDeque<>();

        String input = "";

        while (!"print".equals(input = sc.nextLine())) {
            if (input.equals("cancel")) {
                if (printingQueue.size() > 0) {
                    System.out.println("Canceled " + printingQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printingQueue.offer(input);
            }
        }

        while (!printingQueue.isEmpty()) {
            System.out.println(printingQueue.poll());
        }
    }
}
