package StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expresion = sc.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < expresion.length(); i++) {
            char openBracket = expresion.charAt(i);

            if ('(' == openBracket) {
                stack.push(i);
            } else if (')' == openBracket) {
                System.out.println(expresion.substring(stack.pop(), i + 1));
            }
        }
    }
}
