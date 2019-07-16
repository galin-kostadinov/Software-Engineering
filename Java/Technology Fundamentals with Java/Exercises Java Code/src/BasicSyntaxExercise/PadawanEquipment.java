package BasicSyntaxExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(sc.nextLine());
        int countOfstudents = Integer.parseInt(sc.nextLine());
        double priceOfLightsabers = Double.parseDouble(sc.nextLine());
        double priceOfRobes = Double.parseDouble(sc.nextLine());
        double priceOfBelts = Double.parseDouble(sc.nextLine());
        int freeBeltCount = 0;
        if (countOfstudents >= 6) {
            freeBeltCount = countOfstudents / 6;
        }

        double totalPrice = priceOfLightsabers*(Math.ceil(countOfstudents*1.1))
                + priceOfRobes*countOfstudents+priceOfBelts*(countOfstudents-freeBeltCount);
        if (amountOfMoney >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.%n", totalPrice - amountOfMoney);
        }
    }
}
