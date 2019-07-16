package MethodExercise;

import java.util.Scanner;

public class VowelsCount2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int count = vowelCount(text);

        System.out.println(count);
    }

    static int vowelCount(String text) {
        int count = 0;
        String table = "aieuoAIEUO";
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (table.contains(letter+"")) {
                count++;
            }
        }
        return count;
    }


}
