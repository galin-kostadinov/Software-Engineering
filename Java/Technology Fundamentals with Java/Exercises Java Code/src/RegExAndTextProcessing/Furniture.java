package RegExAndTextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> furniture = new ArrayList<>();
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>\\d+\\.*\\d*)!(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        double totalMoney = 0;
        String input = "";
        while (!"Purchase".equals(input = sc.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                furniture.add(furnitureName);
                double price = Double.parseDouble(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                totalMoney += price * count;
            }
        }
        System.out.println("Bought furniture:");
        furniture.forEach(e -> System.out.printf("%s%n", e));
        System.out.println(String.format("Total money spend: %.2f", totalMoney));
    }
}
