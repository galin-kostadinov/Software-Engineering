package TextProcessingRegularExpressionsMoreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char firstChar = sc.nextLine().charAt(0);
        char lastChar = sc.nextLine().charAt(0);
        String input = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol > firstChar && symbol < lastChar) {
                sum+=symbol;
            }
            if (symbol < firstChar && symbol > lastChar){
                sum+=symbol;
            }

        }
        System.out.println(sum);
    }
}

