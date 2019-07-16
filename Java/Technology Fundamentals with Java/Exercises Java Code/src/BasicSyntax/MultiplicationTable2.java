package BasicSyntax;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int times = Integer.parseInt(sc.nextLine());

        for (int i = times; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n",number, i, i*number);
        }
        if (times>10){
            System.out.printf("%d X %d = %d%n",number, times, times*number);
        }
    }
}
