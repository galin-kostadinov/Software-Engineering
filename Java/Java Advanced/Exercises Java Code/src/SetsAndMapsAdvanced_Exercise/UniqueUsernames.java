package SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        Set<String> names = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            names.add(input);
        }

        names.forEach(n -> System.out.println(n));
    }
}
