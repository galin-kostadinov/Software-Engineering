import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathInFirst = userDir + "\\res\\inputOne.txt";
        String pathInSecond = userDir + "\\res\\inputTwo.txt";
        String pathOut = userDir + "\\res\\outputMerge.txt";

        int pos = 1;
        try (BufferedReader bfrFirstFile = new BufferedReader(new FileReader(pathInFirst));
             BufferedReader bfrSecondFile = new BufferedReader(new FileReader(pathInSecond));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {

            String line = "";
            while ((line = bfrFirstFile.readLine()) != null) {
                    bfw.write(line);
                    bfw.newLine();
            }
            while ((line = bfrSecondFile.readLine()) != null) {
                bfw.write(line);
                bfw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
