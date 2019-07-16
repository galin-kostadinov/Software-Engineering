package TextProcessingRegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "@(?<name>[A-Z]*[a-z]+)\\|(?:.*)#(?<age>\\d+)\\*+";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <n ; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);

            while(matcher.find()){
                String name = matcher.group("name");
                int age = Integer.parseInt( matcher.group("age"));
                System.out.printf("%s is %d years old.%n", name, age);
            }
        }
    }
}
