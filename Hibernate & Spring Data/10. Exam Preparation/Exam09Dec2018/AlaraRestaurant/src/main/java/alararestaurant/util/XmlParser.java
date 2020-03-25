package alararestaurant.util;

public interface XmlParser {
    <T> T objectFromFile(Class<T> tClass, String path);

    <T> void objectToFile(T object, String path);
}
