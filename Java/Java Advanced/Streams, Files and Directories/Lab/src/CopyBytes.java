import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "\\res\\input.txt";
        String pathOut = userDir + "\\res\\output.txt";

        try (FileInputStream fis = new FileInputStream(pathIn);
             FileOutputStream fos = new FileOutputStream(pathOut)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10) {
                    fos.write(oneByte);
                } else {
                    String byteAsText = String.valueOf(oneByte);
                    for (int i = 0; i < byteAsText.length(); i++) {
                        fos.write(byteAsText.charAt(i));
                    }
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

