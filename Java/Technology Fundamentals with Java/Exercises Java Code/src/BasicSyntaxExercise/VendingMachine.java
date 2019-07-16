package BasicSyntaxExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double money = 0.00;

        while (true) {
            String line = sc.nextLine();
            if (line.equals("Start")) {
                break;
            }
            double coin = Double.parseDouble(line);
            if (coin - 0.1 <= 0.00001) {
                money += coin;
            } else if (Math.abs(coin - 0.2) <= 0.00001) {
                money += coin;
            } else if (Math.abs(coin - 0.5) <= 0.00001) {
                money += coin;
            } else if (Math.abs(coin - 1) <= 0.00001) {
                money += coin;
            } else if (Math.abs(coin - 2) <= 0.00001) {
                money += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
        }

        while (true) {
            String product = sc.nextLine();
            if (product.equals("End")) {
                break;
            }

            if (product.equals("Nuts")) {
                if (money - 2.0 >= 0) {
                    System.out.printf("Purchased %s%n", product);
                    money -= 2.0;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (product.equals("Water")) {
                if (money - 0.7 >= 0) {
                    System.out.printf("Purchased %s%n", product);
                    money -= 0.7;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (product.equals("Crisps")) {
                if (money - 1.5 >= 0) {
                    System.out.printf("Purchased %s%n", product);
                    money -= 1.5;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (product.equals("Soda")) {
                if (money - 0.8 >= 0) {
                    System.out.printf("Purchased %s%n", product);
                    money -= 0.8;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (product.equals("Coke")) {
                if (money - 1.0 >= 0) {
                    System.out.printf("Purchased %s%n", product);
                    money -= 1.0;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else{
                System.out.println("Invalid product");
            }
        }
        System.out.printf("Change: %.2f%n",money);
    }
}