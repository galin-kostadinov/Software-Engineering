import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class NestedFolderBFS {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        String path = "E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905"
                + "\\09. Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }

        System.out.println(count + " folders");
    }
}
