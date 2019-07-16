package MethodExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char firstSymbol = sc.nextLine().charAt(0);
        char secondSymbol = sc.nextLine().charAt(0);

        if (firstSymbol > secondSymbol) {
            char symbol = firstSymbol;
            firstSymbol = secondSymbol;
            secondSymbol = symbol;
        }
        printSymbolsInRange(firstSymbol, secondSymbol);
    }

    private static void printSymbolsInRange(char firstSymbol, char secondSymbol) {
        for (int i = (int) firstSymbol + 1; i < secondSymbol; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }
}
