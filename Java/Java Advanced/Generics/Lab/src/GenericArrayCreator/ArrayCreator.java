package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    //Doesn't work!!! Java version?
    public static <T> T[] create(int length, T item) {
       T[] array = (T[]) new Object[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

    //This works, but is not great variant!
    public static <T> T[] create(Class<T> tClass, int length, T item){
        T[]array = (T[]) Array.newInstance(tClass, length);

        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }
}