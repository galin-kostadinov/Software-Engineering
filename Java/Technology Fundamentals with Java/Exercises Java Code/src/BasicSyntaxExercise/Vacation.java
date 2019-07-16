package BasicSyntaxExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine();
        String dayOfWeek = sc.nextLine();
        double pricePerPerson = 0.0;

        switch (typeOfGroup) {
            case "Students":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 8.45;
                        break;
                    case "Saturday":
                        pricePerPerson = 9.80;
                        break;
                    case "Sunday":
                        pricePerPerson = 10.46;
                        break;
                    default:
                        break;
                }
                break;

            case "Business":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 10.90;
                        break;
                    case "Saturday":
                        pricePerPerson = 15.60;
                        break;
                    case "Sunday":
                        pricePerPerson = 16.00;
                        break;
                    default:
                        break;
                }
                break;

            case "Regular":
                switch (dayOfWeek) {
                    case "Friday":
                        pricePerPerson = 15.00;
                        break;
                    case "Saturday":
                        pricePerPerson = 20.00;
                        break;
                    case "Sunday":
                        pricePerPerson = 22.50;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        double totalPrice = pricePerPerson * numberOfPeople;

        if (typeOfGroup.equals("Students") && numberOfPeople >= 30) {
            totalPrice *= 0.85;
        } else if (typeOfGroup.equals("Business") && numberOfPeople >= 100) {
            totalPrice -= pricePerPerson * 10;
        } else if (typeOfGroup.equals("Regular") && (numberOfPeople >= 10 && numberOfPeople <= 20)) {
            totalPrice *= 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
