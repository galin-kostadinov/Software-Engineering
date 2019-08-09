import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        String pathOut = userDir + "\\res\\output.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.setOut(new PrintStream(new FileOutputStream(pathOut), true, "UTF-8"));

        String in ="";
        while (!"STOP".equalsIgnoreCase(in = reader.readLine())){
            System.out.println(in);
        }
    }
}
