package LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(reader.readLine());

        LinkedListTraversal list = new LinkedListTraversal();

        for (int i = 0; i < commandCount; i++) {
            String[] token = reader.readLine().split("\\s++");
            String command = token[0];
            int number = Integer.parseInt(token[1]);

            if (command.equals("Add")) {
                list.add(number);
            } else if (command.equals("Remove")) {
                list.remove(number);
            }
        }

        System.out.println(list.getSize());
        if (list.getSize() > 0) {
            list.forEach(s -> System.out.print(s + " "));
        }
    }
}
