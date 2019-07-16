package BasicSyntaxExercise.MoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = Integer.parseInt(sc.nextLine());
        int num2 = Integer.parseInt(sc.nextLine());
        int num3 = Integer.parseInt(sc.nextLine());

        int maxNum;
        int middleNum;
        int minNum;

        if (num1 >= num2) {
            if (num1 >= num3) {
                maxNum = num1;
                if (num2 >= num3) {
                    middleNum = num2;
                    minNum = num3;
                } else {
                    middleNum = num3;
                    minNum = num2;
                }
            } else {
                maxNum = num3;
                middleNum = num1;
                minNum = num2;
            }
        } else {
            if (num2 >= num3) {
                maxNum = num2;
                if (num3 >= num1) {
                    middleNum = num3;
                    minNum = num1;
                } else {
                    middleNum = num1;
                    minNum = num3;
                }
            } else {
                maxNum = num3;
                middleNum = num2;
                minNum = num1;
            }
        }
        System.out.println(maxNum);
        System.out.println(middleNum);
        System.out.println(minNum);
    }
}

