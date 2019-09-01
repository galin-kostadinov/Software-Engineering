package secondTaskGettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflectionClass = Reflection.class;

        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();

        Method[] getters = getMethodStartsWith("get", allDeclaredMethods);
        Method[] setters = getMethodStartsWith("set", allDeclaredMethods);

        Arrays.stream(getters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        String.format("%s will return class %s",
                                m.getName(),
                                m.getReturnType().getSimpleName()))
                );

        Arrays.stream(setters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        String.format("%s and will set field of class %s",
                                m.getName(),
                                m.getParameterTypes()[0].getSimpleName()))
                );

    }

    public static Method[] getMethodStartsWith(String startWith, Method[] methods) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(startWith))
                .toArray(Method[]::new);
    }
}
