package BasicSyntax;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String countryName = sc.nextLine();
        String language;
        switch (countryName) {
            case "England":
            case "USA":
                language = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                language = "Spanish";
                break;
            default:
                language = "unknown";
                break;
        }
        System.out.println(language);
    }
}
