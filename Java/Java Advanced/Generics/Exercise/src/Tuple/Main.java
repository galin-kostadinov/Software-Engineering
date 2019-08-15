package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        String name = firstLine.substring(0, firstLine.lastIndexOf(" "));
        String address = firstLine.substring(firstLine.lastIndexOf(" ") + 1);

        String secondLine = reader.readLine();
        String person = secondLine.substring(0, secondLine.indexOf(" "));
        int liters = Integer.parseInt(secondLine.substring(secondLine.indexOf(" ") + 1));

        String thirdLine = reader.readLine();
        int number = Integer.parseInt(thirdLine.substring(0, thirdLine.indexOf(" ")));
        double floatingPoint = Double.parseDouble(thirdLine.substring(thirdLine.indexOf(" ") + 1));

        Tuple<String, String> first = new Tuple<>(name, address);
        Tuple<String, Integer> second = new Tuple<>(person, liters);
        Tuple<Integer, Double> third = new Tuple<>(number, floatingPoint);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
