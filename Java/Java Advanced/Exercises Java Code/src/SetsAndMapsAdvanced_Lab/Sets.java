package SetsAndMapsAdvanced_Lab;

import java.util.HashSet;
import java.util.Scanner;

public class Sets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> parkingLot = new HashSet<>();

        String input = "";
        while (!"END".equals(input = sc.nextLine())) {
            String[] token = input.split(",\\s+");

            if (token[0].equals("IN")) {
                parkingLot.add(token[1]);
            } else if (token[0].equals("OUT")) {
                parkingLot.remove(token[1]);
            }
        }

        if (parkingLot.size() > 0) {
            parkingLot.forEach(e -> System.out.println(e));
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
