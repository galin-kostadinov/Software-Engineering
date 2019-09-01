package thirdTaskHighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflectionClass = Reflection.class;

        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();

        Method[] getters = getMethodStartsWith("get", allDeclaredMethods);
        Method[] setters = getMethodStartsWith("set", allDeclaredMethods);
        Field[] fields = reflectionClass.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate((f.getModifiers())))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f ->
                        System.out.println(String.format("%s must be private!", f.getName())));

        Arrays.stream(getters)
                .filter(f -> !Modifier.isPublic((f.getModifiers())))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        String.format("%s have to be public!",
                                m.getName()))
                );

        Arrays.stream(setters)
                .filter(f -> !Modifier.isPrivate((f.getModifiers())))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        String.format("%s have to be private!",
                                m.getName()))
                );

    }

    public static Method[] getMethodStartsWith(String startWith, Method[] methods) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(startWith))
                .toArray(Method[]::new);
    }
}
