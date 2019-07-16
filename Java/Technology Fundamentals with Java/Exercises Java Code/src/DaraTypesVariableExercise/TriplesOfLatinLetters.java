package DaraTypesVariableExercise;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        char endChar = (char) ('a' + number);

        for (char i = 'a'; i < endChar; i++) {
            for (char j = 'a'; j < endChar; j++) {
                for (char k = 'a'; k < endChar; k++) {
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
