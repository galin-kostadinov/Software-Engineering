package firstTaskReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        Reflection reflection = new Reflection();
//        Class someClass = reflection.getClass();

        Class someClass = Reflection.class;

        System.out.println(someClass);

        Class supperClass = someClass.getSuperclass();
        System.out.println(supperClass);

        Class[] someNameInterfaces = someClass.getInterfaces();

        for (Class someNameInterface : someNameInterfaces) {
            System.out.println(someNameInterface);
        }

//        Constructor[] declaredConstructors = someClass.getDeclaredConstructors();
//        for (Constructor declaredConstructor : declaredConstructors) {
//            declaredConstructor.newInstance();
//        }

        Reflection reflection = (Reflection) someClass.getConstructor().newInstance();

        System.out.println(reflection);
    }
}
