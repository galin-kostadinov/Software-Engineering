import java.io.*;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = filePath.substring(0, filePath.lastIndexOf("\\") + 1) + "BigIntOut.txt";

        FileReader fileReader = new FileReader(filePath);

        BufferedReader reader = new BufferedReader(fileReader);

        String line;

        BigInteger totalSum = BigInteger.ZERO;

        while ((line = reader.readLine()) != null) {
            for (char symbol : line.toCharArray()) {
                totalSum = totalSum.add(BigInteger.valueOf(symbol));
            }

        }

        PrintWriter printWriter = new PrintWriter(outputPath);

        printWriter.println(totalSum);

        printWriter.close();
    }
}
