package DaraTypesVariableExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int spices = Integer.parseInt(sc.nextLine());
        int totalAmount = 0;
        int days = 0;

        while (spices >= 100) {
            totalAmount += spices;
            days += 1;
            spices -= 10;
            totalAmount -= 26;
            if (spices < 100) {
                totalAmount-=26;
                break;
            }
        }
        System.out.println(days);
        System.out.println(totalAmount);
    }
}

