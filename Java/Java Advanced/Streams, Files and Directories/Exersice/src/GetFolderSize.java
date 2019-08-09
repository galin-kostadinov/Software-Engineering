import java.io.File;
import java.io.IOException;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File[] files = new File(filePath).listFiles();

        int sum = 0;

        for (File file : files) {
            sum += file.length();
        }

        System.out.println("Folder size: " + sum);
    }
}
