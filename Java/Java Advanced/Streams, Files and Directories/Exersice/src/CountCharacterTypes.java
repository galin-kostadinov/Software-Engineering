import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\ComputerProgramming\\Java\\03_JavaAdvanced\\Java Advanced\\Java Advanced - 201905\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = filePath.substring(0, filePath.lastIndexOf("\\") + 1) + "TypeOfChar.txt";

        String text = Files.readString(Path.of(filePath)).replaceAll("\r\n", " ");

        int[] countData = new int[3];

        String vowels = "aeiou";
        String punctuation = "!,.?";

        for (char symbol : text.toCharArray()) {
            if (vowels.contains(symbol + "")) {
                countData[0]++;
            } else if (punctuation.contains(symbol + "")) {
                countData[2]++;
            } else if (symbol != ' ') {
                countData[1]++;
            }
        }

        PrintWriter printWriter = new PrintWriter(outputPath);

        printWriter.printf("Vowels: %d%n" +
                        "Consonants: %d%n" +
                        "Punctuation: %d",
                countData[0],
                countData[1],
                countData[2]);

        printWriter.close();
    }
}
