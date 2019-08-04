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

        for (String currentSymbol : input) {
            if (Character.isLetterOrDigit(currentSymbol.charAt(0))) {
                queueOutput.offer(currentSymbol);
            } else if (operators.contains(currentSymbol)) {
                while (checkOperatorStack(currentSymbol.charAt(0), operatorStack)) {
                    queueOutput.offer(operatorStack.pop());
                }

                operatorStack.push(currentSymbol);
            } else if (currentSymbol.charAt(0) == '(') {
                operatorStack.push(currentSymbol);
            } else if (currentSymbol.charAt(0) == ')') {
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

        while (!queueOutput.isEmpty()) {
            System.out.printf("%s ", queueOutput.poll());
        }
        System.out.println();
    }

    private static boolean checkOperatorStack(char currentSymbol, ArrayDeque<String> operatorStack) {
        boolean isTrue = true;
        String lastOperator = operatorStack.peek();

        if (operatorStack.isEmpty()) {
            return isTrue = false;
        }

        switch (currentSymbol + "") {
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
