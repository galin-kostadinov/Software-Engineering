package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> url = new ArrayDeque<>();
        ArrayDeque<String> urlForward = new ArrayDeque<>();

        String input = "";

        while (!"Home".equals(input = sc.nextLine())) {
            if (input.equals("back")) {
                if (url.size() > 1) {
                    urlForward.push(url.pop());
                    System.out.println(url.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (urlForward.size() > 0) {
                    url.push(urlForward.pop());
                    System.out.println(url.peek());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                url.push(input);
                System.out.println(url.peek());
                urlForward.clear();
            }
        }
    }
}
