import java.io.File;
import java.io.IOException;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        File f = new File("E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\09. Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] allFiles = f.listFiles();

        DFS(f);

    }

    static void DFS(File root) {
        if (root == null) return;

        File[] files = root.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("DIR" + file.getName());
                DFS(file);
            } else {
                System.out.println(file.getName());
            }
        }
    }
}
