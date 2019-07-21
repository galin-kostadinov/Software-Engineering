package DemoFinalExam21July2019;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String output = "";
        String input = "";
        while (!"End".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (command.equals("Add")) {
                String currentText = tokens[1];
                output += (currentText);
            } else if (command.equals("Upgrade")) {
                char currentSymbol = tokens[1].charAt(0);
                char replacementSymbol = (char) (currentSymbol + 1);

                while (output.contains(currentSymbol + "")) {
                    output = output.replace(currentSymbol, replacementSymbol);
                }
            } else if (command.equals("Print")) {
                System.out.println(output);
            } else if (command.equals("Index")) {
                char currentSymbol = tokens[1].charAt(0);
                if (output.contains(currentSymbol + "")) {
                    for (int i = 0; i < output.length(); i++) {
                        if (currentSymbol == output.charAt(i)) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("Remove")) {
                String currentText = tokens[1];
                while (output.contains(currentText)) {
                    output = output.replace(currentText, "");
                }
            }
        }
    }
}
