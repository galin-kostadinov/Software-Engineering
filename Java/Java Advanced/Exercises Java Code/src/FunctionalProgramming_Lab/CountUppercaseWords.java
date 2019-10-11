package FunctionalProgramming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split("\\s+");

        Predicate<String> isStartingWithCapital = word -> word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        //Character.isUpperCase(word.charAt(0))

        Consumer<String> print = s -> System.out.println(s);

        List<String> capitalWords = Arrays.stream(words)
                .filter(srt -> isStartingWithCapital.test(srt))
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(str -> print.accept(str));
    }
}
