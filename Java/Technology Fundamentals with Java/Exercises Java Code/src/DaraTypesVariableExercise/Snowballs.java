package DaraTypesVariableExercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(sc.nextLine());
        int snowballSnow = 0;
        int snowballTime = 0;
        int snowballQuality = 0;
        double snowballValue = -Double.MAX_VALUE;

        for (int i = 0; i < numberOfSnowballs; i++) {
            int currentSnowballSnow = Integer.parseInt(sc.nextLine());
            int currentSnowballTime = Integer.parseInt(sc.nextLine());
            int currentSnowballQuality = Integer.parseInt(sc.nextLine());
            double currentSnowballValue =  Math.pow(currentSnowballSnow / currentSnowballTime, currentSnowballQuality);

            if (currentSnowballValue >= snowballValue) {
                snowballSnow = currentSnowballSnow;
                snowballTime = currentSnowballTime;
                snowballQuality = currentSnowballQuality;
                snowballValue = currentSnowballValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",
                snowballSnow, snowballTime, snowballValue, snowballQuality);

    }
}
