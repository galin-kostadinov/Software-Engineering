package Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        String firstPerson = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];
        String town = firstLine[3];

        String[] secondLine = reader.readLine().split("\\s+");
        String secondPerson = secondLine[0];
        int liters = Integer.parseInt(secondLine[1]);
        boolean isDrunk = secondLine[2].equals("drunk") ? true : false;

        String[] thirdLine = reader.readLine().split("\\s+");
        String thirdPerson = thirdLine[0];
        double accountBalance = Double.parseDouble(thirdLine[1]);
        String bankName = thirdLine[2];

        Threeuple<String, String, String> first = new Threeuple<>(firstPerson, address, town);
        Threeuple<String, Integer, Boolean> second = new Threeuple<>(secondPerson, liters, isDrunk);
        Threeuple<String, Double, String> third = new Threeuple<>(thirdPerson, accountBalance, bankName);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
