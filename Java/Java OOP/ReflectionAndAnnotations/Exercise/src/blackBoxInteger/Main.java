package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BlackBoxInt blackBoxInt = null;

        Field innerValue = null;

        try {
            Constructor<BlackBoxInt> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            blackBoxInt = declaredConstructor.newInstance();

            innerValue = BlackBoxInt.class.getDeclaredField("innerValue");

            innerValue.setAccessible(true);
        } catch (NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchFieldException ex) {
            ex.printStackTrace();
        }

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();
        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] token = input.split("_");
            String command = token[0];
            int value = Integer.parseInt(token[1]);

            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            if (method != null) {
                method.setAccessible(true);
                try {
                    method.invoke(blackBoxInt, value);

                    System.out.println(innerValue.get(blackBoxInt));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
