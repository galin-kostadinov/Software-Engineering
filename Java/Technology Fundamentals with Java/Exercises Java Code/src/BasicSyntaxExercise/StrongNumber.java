package BasicSyntaxExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numAsString = sc.nextLine();
        int num = Integer.parseInt(numAsString);
        int sum = 0;
        for (int i = 0; i < numAsString.length(); i++) {
            int digit = Integer.parseInt(numAsString.charAt(i) + "");
            int fact = 1;
            for (int j = 2; j <= digit; j++) {
                fact *= j;
            }
            sum+=fact;
        }
        if (sum==num){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
