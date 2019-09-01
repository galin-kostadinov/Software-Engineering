package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class richSoilLandClass = RichSoilLand.class;

        Field[] fields = richSoilLandClass.getDeclaredFields();

        String input;

        while (!"HARVEST".equals(input = reader.readLine())) {
            if (input.equals("all")) {
                Arrays.stream(fields)
                        .forEach(f -> System.out.printf(String.format("%s %s %s%n",
                                Modifier.toString(f.getModifiers()),
                                f.getType().getSimpleName(),
                                f.getName()))
                        );
            }else{
                String finalInput = input;
                Arrays.stream(fields)
                        .filter(f->Modifier.toString(f.getModifiers()).equals(finalInput))
                        .forEach(f -> System.out.printf(String.format("%s %s %s%n",
                                Modifier.toString(f.getModifiers()),
                                f.getType().getSimpleName(),
                                f.getName()))
                        );
            }
        }
    }
}
