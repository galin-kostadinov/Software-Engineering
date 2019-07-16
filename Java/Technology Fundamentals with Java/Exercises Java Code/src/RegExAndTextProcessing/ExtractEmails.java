package RegExAndTextProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "(?<!\\S)[A-Za-z][\\w.-]*@[A-Za-z-]+(?:\\.[A-Za-z]+)+";

        String input = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group().trim());
        }

    }
}
