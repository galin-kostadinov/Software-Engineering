package DaraTypesVariableExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canCount = Integer.parseInt(sc.nextLine());

        String biggestCanModel = sc.nextLine();
        double biggestCanRadius = Double.parseDouble(sc.nextLine());
        int biggestCanHeight = Integer.parseInt(sc.nextLine());
        double biggestCanVolume = Math.PI * biggestCanRadius * biggestCanRadius * biggestCanHeight;

        for (int i = 0; i < canCount - 1; i++) {
            String currentCanModel = sc.nextLine();
            double currentCanRadius = Double.parseDouble(sc.nextLine());
            int currentCanHeight = Integer.parseInt(sc.nextLine());
            double currentCanVolume = Math.PI * currentCanRadius * currentCanRadius * currentCanHeight;

            if (currentCanVolume > biggestCanVolume) {
                biggestCanModel = currentCanModel;
                biggestCanVolume = currentCanVolume;
            }
        }
        System.out.println(biggestCanModel);
    }
}
