package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String brackets = sc.nextLine();

        ArrayDeque<Character> bracketsStack = new ArrayDeque<>();

        boolean areBalanced = true;

        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);

            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                bracketsStack.push(currentBracket);
            } else {
                if (bracketsStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char topElement = bracketsStack.pop();

                if (currentBracket == ']' && topElement != '[') {
                    areBalanced = false;
                    break;
                } else if (currentBracket == '}' && topElement != '{') {
                    areBalanced = false;
                    break;
                } else if (currentBracket == ')' && topElement != '(') {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
