package Articles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] data = reader.readLine().split(", ");

        String title = data[0];
        String content = data[1];
        String author = data[2];

        Article article = new Article(title, content, author);


        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(": ");
            String command = input[0];

            switch (command) {
                case "Edit":

                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;

                default:
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
