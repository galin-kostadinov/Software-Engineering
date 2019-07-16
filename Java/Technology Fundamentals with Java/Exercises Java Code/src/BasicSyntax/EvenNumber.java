package BasicSyntax;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int evenNumber;

        while (true) {
            evenNumber = Integer.parseInt(sc.nextLine());
            if (evenNumber % 2 == 0) {
                System.out.printf("The number is: %d%n",Math.abs(evenNumber));
                break;
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
