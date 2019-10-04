import java.io.*;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) throws IOException {
       // String filePath = "E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        String userDir = System.getProperty("user.dir");
        String filePath = userDir + "\\res\\input.txt";

        String outputPath = filePath.substring(0, filePath.lastIndexOf("\\") + 1) + "BigIntOut.txt";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

       // BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        String line;

        BigInteger totalSum = BigInteger.ZERO;

        while ((line = reader.readLine()) != null) {
            for (char symbol : line.toCharArray()) {
                totalSum = totalSum.add(BigInteger.valueOf(symbol));
            }

        }
        reader.close();

        PrintWriter printWriter = new PrintWriter(outputPath);

        printWriter.println(totalSum);

        printWriter.close();
    }
}
