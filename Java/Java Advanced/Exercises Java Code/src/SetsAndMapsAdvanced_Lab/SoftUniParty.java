package SetsAndMapsAdvanced_Lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = sc.nextLine())) {
            if (input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    vipGuests.add(input);
                } else {
                    regularGuests.add(input);
                }
            }
        }

        while (!"END".equals(input = sc.nextLine())) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(e -> System.out.println(e));
        regularGuests.forEach(e -> System.out.println(e));
    }
}
