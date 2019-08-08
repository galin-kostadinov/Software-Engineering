package SetsAndMapsAdvanced_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> contacts = new HashMap<>();

        String input;
        while (!"search".equals(input = sc.nextLine())) {
            String[] tokens = input.split("-");
            if (tokens.length == 2) {
                String name = tokens[0];
                String phone = tokens[1];

                contacts.put(name, phone);
            }
        }

        String name;
        while (!"stop".equals(name = sc.nextLine())) {
            if (contacts.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, contacts.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
        }
    }
}
