package BasicSyntaxExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());

        int headsetCount = lostGamesCount / 2;
        int mouseCount = lostGamesCount / 3;
        int keyboardCount = 0;
        int displayCount = 0;

        int counter = 1;
        while (counter <= lostGamesCount) {

            if (counter % 2 == 0 && counter % 3 == 0) {
                keyboardCount++;
            }
            counter++;
        }
        displayCount = keyboardCount / 2;
        double totalPrice = headsetCount * headsetPrice + mouseCount * mousePrice
                + keyboardCount * keyboardPrice + displayCount * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.%n", totalPrice);
    }
}
