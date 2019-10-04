import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\res\\output.ser";

        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Mimi", "Gosho");

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(names);

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<String> names2 = (List<String>) ois.readObject();
        System.out.println(names2);
    }
}
