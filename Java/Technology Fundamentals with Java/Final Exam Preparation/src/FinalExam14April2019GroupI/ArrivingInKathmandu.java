package FinalExam14April2019GroupI;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "^(?<rawName>[A-Za-z0-9!@#$?]+)=(?<length>[0-9]+)<<(?<geohashCode>.+)";
        String regexName = "(?<name>[A-Za-z0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Pattern patternName = Pattern.compile(regexName);

        String input = "";
        while (!"Last note".equals(input = sc.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            String rawName = "";
            int length = 0;
            String geohashCode = "";
            boolean isFound = false;
            if (matcher.find()) {
                rawName = matcher.group("rawName");
                length = Integer.parseInt(matcher.group("length"));
                geohashCode = matcher.group("geohashCode");
                if (length == geohashCode.length()) {
                    isFound = true;
                }
            }

            if (isFound) {
                StringBuilder name = new StringBuilder(length);
                Matcher matcherName = patternName.matcher(rawName);
                while(matcherName.find()){
                    name.append(matcherName.group("name"));
                }
                System.out.printf("Coordinates found! %s -> %s%n", name, geohashCode);
                isFound = false;
            } else {
                System.out.println("Nothing found!");
            }
        }


    }
}
