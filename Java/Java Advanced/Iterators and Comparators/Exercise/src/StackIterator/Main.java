package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomStack stack = new CustomStack();

        String input = "";

        while (!"END".equals(input = reader.readLine())) {
            if (input.contains("Push")) {
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(input);

                while (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    stack.push(number);
                }
            } else if (input.contains("Pop")) {
                stack.pop();
            }
        }

        for (Integer element : stack) {
            System.out.println(element);
        }
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}
