package DaraTypesVariableExercise;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNum = Integer.parseInt(sc.nextLine());
        int secondNum = Integer.parseInt(sc.nextLine());
        int thirdNum = Integer.parseInt(sc.nextLine());
        int fourthNum = Integer.parseInt(sc.nextLine());

        int result = fourthNum*(firstNum+secondNum)/thirdNum;

        System.out.println(result);
    }
}
