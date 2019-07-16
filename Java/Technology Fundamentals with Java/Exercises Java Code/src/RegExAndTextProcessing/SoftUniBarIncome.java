package RegExAndTextProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "%(?<customer>[A-Z][a-z]+)%" +
                "(?:[^|$%.]*)<(?<product>[^<>]+)>" +
                "(?:[^|$%.]*)\\|(?<count>\\d+)" +
                "\\|(?:[^|$%.]*?)(?<price>[-+]?\\d+\\.?\\d+)\\$";

        Pattern pattern = Pattern.compile(regex);

        String input = "";
        double totalIncome = 0;
        while (!"end of shift".equals(input = sc.nextLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = price * count;
                System.out.println(String.format(
                        "%s: %s - %.2f",
                        customer,
                        product,
                        totalPrice
                ));
                totalIncome += totalPrice;
            }
        }
        System.out.printf("Total income: %.2f%n",totalIncome);
    }
}
