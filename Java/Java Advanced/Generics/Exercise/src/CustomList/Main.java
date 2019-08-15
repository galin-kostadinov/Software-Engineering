package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> list = new CustomList<String>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    CustomList.printList(list);

                    //list.forEach(System.out::println);
                    break;
            }
        }
    }
}
