package DaraTypesVariableExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pokePower = Integer.parseInt(sc.nextLine());
        int distance = Integer.parseInt(sc.nextLine());
        int exhaustionFactor = Integer.parseInt(sc.nextLine());

        int totalTargetCount = 0;
        int currentPokePower = pokePower;

        while (currentPokePower >= distance) {
            currentPokePower -= distance;
            totalTargetCount++;
            if (currentPokePower == pokePower / 2.00 && exhaustionFactor > 0) {
                currentPokePower/=exhaustionFactor;
            }
        }

        System.out.println(currentPokePower);
        System.out.println(totalTargetCount);
    }
}
