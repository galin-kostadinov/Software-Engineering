import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) throws IOException {
        String picInputPath = "E:\\ComputerProgramming\\pics\\JavaLogo.jpg";
        String picOutputPath = "E:\\ComputerProgramming\\pics\\JavaLogo-copy.txt";
        FileInputStream inputStream = new FileInputStream(picInputPath);

        byte[] image = inputStream.readAllBytes();

        FileOutputStream outputStream = new FileOutputStream(picOutputPath);

        outputStream.write(image);

        outputStream.close();
    }
}
