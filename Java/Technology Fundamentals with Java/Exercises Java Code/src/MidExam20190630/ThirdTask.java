package MidExam20190630;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> contacts = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        while (true) {
            String input = sc.nextLine();
            String[] token = input.split("\\s+");
            if (input.contains("Add")) {
                String contact = token[1];
                int index = Integer.parseInt(token[2]);
                if (!contacts.contains(contact)) {
                    contacts.add(contact);
                } else {
                    if (index >= 0 && index < contacts.size()) {
//remove
                        contacts.add(index, contact);
                    }
                }
            } else if (input.contains("Remove")) {
                int index = Integer.parseInt(token[1]);
                if (index >= 0 && index < contacts.size()) {
                    contacts.remove(index);
                }
            } else if (input.contains("Export")) {
                int startIndex = Integer.parseInt(token[1]);
                int count = Integer.parseInt(token[2]);
                if (startIndex >= 0 && startIndex < contacts.size()) {
                    int endIndex = count-1 + startIndex;
                    if (endIndex > contacts.size() - 1) {
                        endIndex = contacts.size() - 1;
                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        System.out.printf("%s ", contacts.get(i));
                    }
                    System.out.println();
                }

            } else if (input.contains("Print Normal")) {
                System.out.printf("Contacts: ");
                contacts.forEach(e -> System.out.printf("%s ", e));
                System.out.println();
                return;
            } else if (input.contains("Print Reversed")) {
                System.out.printf("Contacts: ");
                Collections.reverse(contacts);
                contacts.forEach(e -> System.out.printf("%s ", e));
                System.out.println();
                return;
            }
        }
    }
}
