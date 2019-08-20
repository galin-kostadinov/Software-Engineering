package CardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        System.out.println(input + ":");

        for (CardRank nameValue : CardRank.values()) {
            int ordinalValue = nameValue.ordinal();
            System.out.printf("Ordinal value: %d; Name value: %s%n", ordinalValue, nameValue);
        }
    }
}
