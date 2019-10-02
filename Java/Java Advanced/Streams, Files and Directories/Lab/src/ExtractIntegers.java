import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "\\res\\input.txt";
        String pathOut = userDir + "\\res\\outputInt2.txt";

        try (Scanner sc = new Scanner(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut)) {

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    writer.println(sc.nextInt());
                } else {
                    sc.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

