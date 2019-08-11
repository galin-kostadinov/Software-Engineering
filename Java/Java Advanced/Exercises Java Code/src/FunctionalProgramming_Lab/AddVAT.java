package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] split = reader.readLine().split(", ");

        UnaryOperator<Double> addVat = d -> 1.2 * d;

        System.out.println("Prices with VAT:");
        Arrays.stream(split)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
