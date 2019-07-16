package ArraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstText = sc.nextLine().split(" ");
        String[] secondText = sc.nextLine().split(" ");

        for (int i = 0; i <secondText.length ; i++) {
            for (int j = 0; j < firstText.length; j++) {
                if (firstText[j].contains(secondText[i])){
                    System.out.print(secondText[i] + " ");
                }
            }
        }
        System.out.println();
    }
}
