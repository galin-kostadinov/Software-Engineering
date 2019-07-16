package TextProcessingRegularExpressionsMoreExercise;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine();
        String content = sc.nextLine();

        System.out.println("<h1>");
        System.out.printf(" %s%n",title);
        System.out.println("</h1>");

        System.out.println("<article>");
        System.out.printf(" %s%n",content);
        System.out.println("</article>");

        String input = "";
        while (!"end of comments".equals(input = sc.nextLine())) {
            System.out.println("<div>");
            System.out.printf(" %s%n",input);
            System.out.println("</div>");
        }
    }
}
