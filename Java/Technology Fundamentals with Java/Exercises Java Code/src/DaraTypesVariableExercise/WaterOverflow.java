package DaraTypesVariableExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        int waterTankCapacity = 255;
        int waterInTank = 0;

        for (int i = 0; i < numberOfInputs; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            boolean enoughCapacity = waterTankCapacity - waterInTank >= input ? true : false;
            if (enoughCapacity){
                waterInTank+=input;
            }else{
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(waterInTank);
    }
}
