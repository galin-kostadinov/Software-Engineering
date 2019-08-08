package SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> personsEmails = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = sc.nextLine())) {
            String email = sc.nextLine();
            if (!email.contains(".us") && !email.contains(".com")
                    && !email.contains(".uk")) {
                personsEmails.put(name, email);
            }
        }

        personsEmails.forEach((person, email) -> System.out.printf("%s -> %s%n", person, email));
    }
}
