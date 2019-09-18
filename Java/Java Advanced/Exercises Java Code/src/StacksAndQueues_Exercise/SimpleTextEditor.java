package StacksAndQueues_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = "";
        ArrayDeque<String> previousCommands = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    previousCommands.push(text);
                    text += tokens[1];

                    break;
                case "2":
                    previousCommands.push(text);
                    int endIndex = text.length() - Integer.parseInt(tokens[1]);
                    text = text.substring(0, endIndex);

                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    text = previousCommands.pop();
                    break;
            }
        }
    }
}
