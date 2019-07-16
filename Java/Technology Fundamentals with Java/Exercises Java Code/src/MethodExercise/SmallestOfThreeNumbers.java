package MethodExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = Integer.parseInt(sc.nextLine());
        int secondNum = Integer.parseInt(sc.nextLine());
        int thirdNum = Integer.parseInt(sc.nextLine());

        int minElement = min(firstNum,secondNum);
        minElement=min(minElement,thirdNum);
        System.out.println(minElement);
    }
    static int min(int first, int second){
        return Math.min(first,second);
    }
}
