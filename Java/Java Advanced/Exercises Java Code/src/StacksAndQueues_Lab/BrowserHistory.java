package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> url = new ArrayDeque<>();
        String input = "";

        while (!"Home".equals(input = sc.nextLine())) {
            if (input.equals("back")) {
                if (url.size() > 1) {
                    url.pop();
                    System.out.println(url.peek());
                }else{
                    System.out.println("no previous URLs");
                }
            } else {
                url.push(input);
                System.out.println(url.peek());
            }
        }
    }
}

