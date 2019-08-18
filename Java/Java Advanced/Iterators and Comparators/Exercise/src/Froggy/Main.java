package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lake numbers = new Lake();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            List<Integer> tokens = Arrays.stream(input.split(",\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            numbers.setElements(tokens);
        }

        List<String> numsAsString = new ArrayList<>();

        for (Integer number : numbers) {
            numsAsString.add(number.toString());
        }

        System.out.println(String.join(", ", numsAsString));
    }
}
