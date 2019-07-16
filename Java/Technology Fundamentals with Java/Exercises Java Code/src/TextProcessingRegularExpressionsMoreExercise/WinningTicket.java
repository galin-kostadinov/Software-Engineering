package TextProcessingRegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tickets = sc.nextLine().split("[\\s*,\\s+]+".trim());
        //String regex = "[$]{6,}|[@]{6,}|[#]{6,}[\\^]{6,}";
        String regex = "[\\\\@]{6,}|[\\\\$]{6,}|[\\\\#]{6,}|[\\\\^]{6,}";
        Pattern pattern = Pattern.compile(regex);;
        for (int i = 0; i < tickets.length; i++) {
            String currentTicket = tickets[i];
            if (currentTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            String leftPart = currentTicket.substring(0, 10);
            String rightPart = currentTicket.substring(10);
            Matcher leftMatcher = pattern.matcher(leftPart);
            Matcher rightMatcher = pattern.matcher(rightPart);

            String leftText = "left";
            String rightText = "right";

            if (leftMatcher.find()) {
                leftText = leftMatcher.group();
            }
            if (rightMatcher.find()) {
                rightText = rightMatcher.group();
            }
            if (leftText.substring(0,1).equals(rightText.substring(0,1))) {
                int matchLength = Math.min(leftText.length(), rightText.length());
                char matchSymbol = leftText.charAt(0);
                if (matchLength == 10) {
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",
                            currentTicket,
                            matchLength,
                            matchSymbol);
                } else {
                    System.out.printf("ticket \"%s\" - %d%c%n",
                            currentTicket,
                            matchLength,
                            matchSymbol);
                }
            } else {
                System.out.printf("ticket \"%s\" - no match%n", currentTicket);
            }
        }
    }
}
