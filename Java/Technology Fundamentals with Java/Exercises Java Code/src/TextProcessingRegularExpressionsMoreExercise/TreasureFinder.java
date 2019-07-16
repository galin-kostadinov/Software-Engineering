package TextProcessingRegularExpressionsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<String> massages = new ArrayList<>();
        String input = "";
        while (!"find".equals(input = sc.nextLine())) {
            if (nums.length <= input.length()) {
                StringBuilder newText = new StringBuilder();
                int index = 0;
                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    if (index >= nums.length) {
                        index = 0;
                    }
                    char newSymbol = (char) (currentSymbol - nums[index]);
                    newText.append(newSymbol);
                    index++;
                }
                massages.add(newText.toString());
            }
        }
        String regex = "&(?<type>[A-Za-z]+)&(?:[^<>]*)<(?<coordinates>[A-Za-z0-9]+)>";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < massages.size(); i++) {
            String text = massages.get(i);
            Matcher matcher = pattern.matcher(text);

            if (!matcher.find()) {
                break;
            }
            String type = matcher.group("type");
            String coordinates = matcher.group("coordinates");

            System.out.println(String.format("Found %s at %s",type, coordinates));
        }
    }
}
