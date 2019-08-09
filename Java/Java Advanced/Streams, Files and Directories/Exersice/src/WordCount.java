import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        Path textInPath = Paths.get(userDir + "\\res\\text.txt");
        Path wordsInPath = Paths.get(userDir + "\\res\\words.txt");
        String pathOut = userDir + "\\res\\result.txt";

        List<String> inputText = Files.readAllLines(textInPath)
                .parallelStream()
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());
        System.out.println();

        List<String> inputWord = new ArrayList<>();

        Files.readAllLines(wordsInPath)
                .parallelStream()
                .filter(s -> !s.isEmpty())
                .forEach(inputWord::add);
        System.out.println();

        inputWord = Arrays.stream(inputWord.get(0).split("\\s+")).collect(Collectors.toList());

        Pattern pattern = Pattern.compile("(?<word>[A-Za-z]+)");

        try (BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {
            for (int i = 0; i < inputWord.size(); i++) {
                String currentWord = inputWord.get(i);
                int counter = 0;
                Matcher matcher = pattern.matcher(inputText.get(0));
                while (matcher.find()) {
                    if (matcher.group("word").equals(currentWord)) {
                        counter++;
                    }
                }
                bfw.write(currentWord + " - " + counter);
                bfw.newLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
