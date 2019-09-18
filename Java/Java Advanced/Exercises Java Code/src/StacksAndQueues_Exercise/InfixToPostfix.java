package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+".trim());

        ArrayDeque<String> queueOutput = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        String operators = "+-*/";

        for (String symbol : input) {
            char currentChar = symbol.charAt(0);

            if (Character.isLetterOrDigit(currentChar)) {
                queueOutput.offer(symbol);
            } else if (operators.contains(symbol)) {
                while (checkOperatorStack(currentChar, operatorStack)) {
                    queueOutput.offer(operatorStack.pop());
                }

                operatorStack.push(symbol);
            } else if (currentChar == '(') {
                operatorStack.push(symbol);
            } else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek().charAt(0) != '(') {
                    queueOutput.offer(operatorStack.pop());
                }

                if (!operatorStack.isEmpty() && operatorStack.peek().charAt(0) == '(') {
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            queueOutput.offer(operatorStack.pop());
        }

        System.out.println(String.join(" ", queueOutput));
    }

    private static boolean checkOperatorStack(char currentChar, ArrayDeque<String> operatorStack) {
        boolean isTrue = true;
        String lastOperator = operatorStack.peek();

        if (operatorStack.isEmpty()) {
            return isTrue = false;
        }

        switch (currentChar + "") {
            case "+":
            case "-":
                if (lastOperator.equals("(")) {
                    isTrue = false;
                }
                break;
            case "*":
            case "/":
                if (lastOperator.equals("*") || lastOperator.equals("/")) {
                    isTrue = true;
                } else {
                    isTrue = false;
                }
                break;
            case "(":
                isTrue = false;
                break;
        }

        return isTrue;
    }
}