package MethodExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = Integer.parseInt(sc.nextLine());
        int secondNum = Integer.parseInt(sc.nextLine());
        int thirdNum = Integer.parseInt(sc.nextLine());
        int result = sum(firstNum, secondNum);
        result = subtract(result, thirdNum);

        System.out.println(result);
    }

    static int sum(int first, int second) {

        return first + second;
    }

    static int subtract(int first, int second) {

        return first - second;
    }
}
