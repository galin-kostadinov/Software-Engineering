import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "\\res\\inputLineNumbers.txt";
        String pathOut = userDir + "\\res\\output.txt";

        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {

            String line = "";
            int i = 1;
            while ((line = bfr.readLine()) != null) {

                bfw.write(i + ". " + line);
                bfw.newLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
