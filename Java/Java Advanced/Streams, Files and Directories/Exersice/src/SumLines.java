import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = filePath.substring(0, filePath.lastIndexOf("\\") + 2) + "asciiSum.txt";

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath)));
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                int asciiSum = 0;
                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }

                writer.write(asciiSum + "");
                writer.write(System.lineSeparator());

                line = reader.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        writer.close();
    }
}
