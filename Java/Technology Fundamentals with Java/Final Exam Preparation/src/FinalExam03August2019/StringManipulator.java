package FinalExam03August2019;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String input = "";

        while (!"End".equals(input = sc.nextLine())) {
            String[] token = input.split("\\s+".trim());
            String command = token[0];

            if (command.equals("Translate")) {
                String textSymbol = token[1];
                String replacement = token[2];

                while (text.contains(textSymbol)) {
                    text = text.replace(textSymbol, replacement);
                }

                System.out.println(text);
            } else if (command.equals("Includes")) {
                String searchedText = token[1];

                if (text.contains(searchedText)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.equals("Start")) {
                String searchedText = token[1];

                String cutText = null;

                if (searchedText.length() <= text.length()) {
                    cutText = text.substring(0, searchedText.length());
                }

                if (!cutText.equals(null) && cutText.equals(searchedText)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.equals("Lowercase")) {
                text = text.toLowerCase();
                System.out.println(text);
            } else if (command.equals("FindIndex")) {
                char symbol = token[1].charAt(0);
                int index = -1;

                for (int i = 0; i < text.length(); i++) {
                    int currentSymbol = text.charAt(i);

                    if (currentSymbol == symbol) {
                        index = i;
                    }
                }

                if (index != -1) {
                    System.out.println(index);
                }
            } else if (command.equals("Remove")) {
                int startIndex = Integer.parseInt(token[1]);
                int count = Integer.parseInt(token[2]);

                String removeText = text.substring(startIndex, startIndex + count);
                text = text.replace(removeText, "");

                System.out.println(text);
            }
        }
    }
}
