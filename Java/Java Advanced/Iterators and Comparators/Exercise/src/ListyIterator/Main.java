package ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListyIterator iterator = new ListyIterator(list);

        String input;
        while (!"END".equals(input = reader.readLine())) {
            switch (input) {
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    try {
                        iterator.print();
                    } catch (IllegalAccessException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "PrintAll":
                    iterator.printAll();
                    break;
            }
        }
    }
}
