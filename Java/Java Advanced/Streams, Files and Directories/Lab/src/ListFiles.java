import java.io.File;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        File f = new File("E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\09. Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] allFiles = f.listFiles();

        if (allFiles == null) {
            return;
        }

        for (File f1 : allFiles) {
            if (!f1.isDirectory()) {
                System.out.println(String
                        .format("%s: [%d]", f1.getName(), f1.length()));
            }
        }
    }
}
