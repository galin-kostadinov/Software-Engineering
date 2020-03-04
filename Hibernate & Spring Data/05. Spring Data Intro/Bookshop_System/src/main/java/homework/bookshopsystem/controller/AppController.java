package homework.bookshopsystem.controller;

import homework.bookshopsystem.serveces.AuthorService;
import homework.bookshopsystem.serveces.BookService;
import homework.bookshopsystem.serveces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public AppController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.authorService.seedAuthor();
        this.categoryService.seedCategory();
        this.bookService.seedBooks();

        int choice;

        while (true) {
            System.out.println("Enter 1 to 'Get all books after the year 2000.'");
            System.out.println("Enter 2 to 'Get all authors with at least one book with release date before 1990.'");
            System.out.println("Enter 3 to 'Get all authors, ordered by the number of their books (descending).'");
            System.out.println("Enter 4 to 'Get all books from author George Powell.'");
            System.out.println("Enter 0 to Exit");
            System.out.println();
            System.out.println("Please, Enter your choice:");
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 0:
                    System.out.println("Buy!");
                    return;
                case 1:
                    allBookAfterYear2000();
                    break;
                case 2:
                    allAuthorsWithBookReleaseBefore1990();
                    break;
                case 3:
                    allAuthorsOrderByBooksCount();
                    break;
                case 4:
                    allBooksByGeorgePowell();
                    break;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;
            }
        }
    }

    private void allBooksByGeorgePowell() {
        List<String> authors = this.bookService.getAllBooksByGeorgePowell();

        printDashRow();
        System.out.println("All books from author George Powell:");
        printDashRow();
        System.out.println(String.format("|%-25s|%15s|%10s|", "Title", "Release date", "Copies"));
        printDashRow();

        authors.forEach(System.out::println);

        printDashRow();
        System.out.println();
    }

    private void allAuthorsOrderByBooksCount() {
        List<String> authors = this.authorService.getAllAuthorsOrderByBooksCount();

        printDashRow();
        System.out.println("All authors, ordered by the number of their books (descending):");
        printDashRow();
        System.out.println(String.format("|%12s %-12s|%12s|", "Author", "name", "Books count"));
        printDashRow();

        authors.forEach(System.out::println);

        printDashRow();
        System.out.println();
    }

    private void allAuthorsWithBookReleaseBefore1990() {
        List<String> authors = this.bookService.findAllAuthors();

        printDashRow();
        System.out.println("Authors names with at least one book with release date before 1990:");
        printDashRow();

        authors.forEach(System.out::println);

        printDashRow();
        System.out.println();
    }

    private void allBookAfterYear2000() {
        List<String> booksAfter2000 = this.bookService.findAllTitles();

        printDashRow();
        System.out.println("All book' titles after the year 2000:");
        printDashRow();

        booksAfter2000.forEach(System.out::println);

        printDashRow();
        System.out.println();
    }

    private void printDashRow() {
        System.out.println("---------------------------------------------------------");
    }
}
