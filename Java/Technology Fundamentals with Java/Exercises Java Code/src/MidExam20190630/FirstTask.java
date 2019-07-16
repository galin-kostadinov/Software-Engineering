package MidExam20190630;

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = Integer.parseInt(sc.nextLine());
        double lengthByStepCm = Double.parseDouble(sc.nextLine());
        int distance = Integer.parseInt(sc.nextLine());
        distance *= 100;
        double totalDistance = 0;
        for (int i = 1; i <= steps; i++) {
            if (i % 5 == 0) {
                totalDistance += lengthByStepCm * 0.7;

            } else {
                totalDistance += lengthByStepCm;
            }

        }
        double percentage = 100.0*totalDistance / distance;

        System.out.printf("You travelled %.2f%% of the distance!%n",percentage);
    }
}
