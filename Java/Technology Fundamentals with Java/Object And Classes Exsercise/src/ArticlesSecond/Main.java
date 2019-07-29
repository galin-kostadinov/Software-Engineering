package ArticlesSecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article currentArticle = new Article(title, content, author);

            articles.add(currentArticle);
        }
        String sortCriteria = reader.readLine();

        if (sortCriteria.equals("title")) {
            articles.stream().sorted((p1, p2) ->
                    p1.getTitle().compareTo(p2.getTitle()))
                    .forEach(article-> System.out.println(article.toString()));
        }else if (sortCriteria.equals("content")) {
            articles.stream().sorted((p1, p2) ->
                    p1.getContent().compareTo(p2.getContent()))
                    .forEach(article-> System.out.println(article.toString()));
        }else if (sortCriteria.equals("author")) {
            articles.stream().sorted((p1, p2) ->
                    p1.getAuthor().compareTo(p2.getAuthor()))
                    .forEach(article-> System.out.println(article.toString()));
        }
    }
}
