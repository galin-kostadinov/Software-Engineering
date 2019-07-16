package BasicSyntax;

import java.util.Scanner;

public class BackAfterMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        minutes += 30;
        if (minutes>=60){
            hours+=1;
            minutes-=60;
        }
        if (hours>=24){
            hours-=24;
        }
        System.out.printf("%d:%02d",hours,minutes);
    }
}
