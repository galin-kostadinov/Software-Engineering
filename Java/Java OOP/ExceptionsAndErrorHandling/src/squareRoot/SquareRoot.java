package squareRoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int a = Integer.parseInt(reader.readLine());
            double result = Math.sqrt(a);
            System.out.println(result);
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Invalid number");
        } finally {
            System.out.println("Good bye");
        }
    }
}
