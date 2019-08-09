import java.io.*;

public class WriteEveryThirdLine {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "\\res\\input.txt";
        String pathOut = userDir + "\\res\\output.txt";

        int pos = 1;
        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {

            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (pos % 3 == 0) {
                    bfw.write(line);
                    bfw.newLine();
                    //bfw.append(line).append(System.lineSeparator());

                }
                pos++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        If we don`t Using try-with-resources, then:
                 finally:
                 bfw.flush();
                 bfw.close();
        */
    }
}
