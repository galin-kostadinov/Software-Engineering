package BasicSyntaxExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        String password = "";

        for (int i = userName.length() - 1; i >= 0; i--) {
            password += userName.charAt(i);
        }
        int counter = 0;
        while (true) {
            String line = sc.nextLine();
            if (password.equals(line)) {
                System.out.printf("User %s logged in.%n", userName);
                break;
            }

            counter++;
            if (counter==4){
                System.out.printf("User %s blocked!",userName);
                break;
            }
            System.out.println("Incorrect password. Try again.");
        }
    }
}
