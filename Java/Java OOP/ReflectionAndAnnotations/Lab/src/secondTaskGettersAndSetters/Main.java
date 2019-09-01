package secondTaskGettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflectionClass = Reflection.class;

        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(allDeclaredMethods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        String.format("%s will return class %s",
                                m.getName(),
                                m.getReturnType().getName()))
                );

        Arrays.stream(allDeclaredMethods)
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        String.format("%s and will set field of class %s",
                                m.getName(),
                                m.getParameterTypes()[0].getName()))
                );

    }
}
