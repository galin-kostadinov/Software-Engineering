package DemoFinalExam06April2019;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "^([d-z{}|#]+)$";
        Pattern pattern = Pattern.compile(regex);

        String encryptedString = sc.nextLine();
        String[] twoSubstrings = sc.nextLine().split("\\s+");

        Matcher matcher = pattern.matcher(encryptedString);
        if (matcher.find()) {
            StringBuilder decryptedText = new StringBuilder();
            for (int i = 0; i < encryptedString.length(); i++) {
                char currentSymbol = (char) (encryptedString.charAt(i) - 3);
                decryptedText.append(currentSymbol);
            }
            String output = decryptedText.toString();
            while(output.contains(twoSubstrings[0])){
                output = output.replace(twoSubstrings[0], twoSubstrings[1]);
            }
            System.out.println(output);
        } else {
            System.out.println("This is not the book you are looking for.");
        }


    }
}
