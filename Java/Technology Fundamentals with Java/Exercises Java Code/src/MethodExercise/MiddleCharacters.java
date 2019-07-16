package MethodExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        printMiddleCharacter(text);

        System.out.println();
    }

    private static void printMiddleCharacter(String text) {
        if (text.length()%2==0){
            System.out.println(text.charAt(text.length()/2-1)+""+text.charAt(text.length()/2));
        }
        else{
            System.out.println(text.charAt(text.length()/2));
        }
    }
}
