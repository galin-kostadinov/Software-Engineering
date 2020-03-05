package bookshopsystemapp.controller;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

@Controller
public class BookshopController implements CommandLineRunner {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

        int choice;

        while (true) {
            printDashRow();
            System.out.println("Enter 1 to get 'Books Titles by Age Restriction'");
            System.out.println("Enter 2 to get 'Golden Books'");
            System.out.println("Enter 3 to get 'Books by Price'");
            System.out.println("Enter 4 to get 'Not Released Books' in current Year");
            System.out.println("Enter 5 to get 'Books Released Before Date'");
            System.out.println("Enter 6 for 'Authors Search' by criteria");
            System.out.println("Enter 7 for 'Books Search' by criteria");


            System.out.println("Enter 0 to Exit");
            printDashRow();
            System.out.println();
            System.out.println("Please, Enter your choice:");
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 0:
                    System.out.println("Buy!");
                    return;
                case 1:
                    getBooksTitlesByAgeRestriction();
                    break;
                case 2:
                    getGoldenBooks();
                    break;
                case 3:
                    getBooksInPriceRange();
                    break;
                case 4:
                    getNotReleasedBooks();
                case 5:
                    getBooksReleasedBeforeDate();
                    break;
                case 6:
                    getAuthorsByFirstNameCriteria();
                    break;
                case 7:
                    getBooksWithTitleContainCurrText();
                    break;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;
            }
        }
    }

    private void getBooksTitlesByAgeRestriction() throws IOException {
        printDashRow();
        System.out.println("Enter age restriction(for example -> 'miNor'):");
        String ageRestStr = br.readLine();

        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestStr.toUpperCase());

        bookService.getAllBookTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
        printDashRow();
    }

    private void getGoldenBooks() {
        bookService.getAllBookWithGoldenEditionTypeAndCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void getBooksInPriceRange() throws IOException {
        this.bookService.getBookInPriceRange().forEach(System.out::println);
    }

    private void getNotReleasedBooks() throws IOException {
        System.out.println("Please, Enter an year(for example -> '2000'):");

        String year = br.readLine();

        this.bookService.getBookNotReleasedInCurrYear(year).forEach(System.out::println);
    }

    private void getBooksReleasedBeforeDate() throws IOException {
        System.out.println("Please, Enter a Date in format dd-MM-yyyy(for example -> '12-04-1992'):");
        String date = br.readLine();

        this.bookService.getAllBooksBefore(date).forEach(System.out::println);
    }

    private void getAuthorsByFirstNameCriteria() throws IOException {
        System.out.println("Please, Enter the end letters of Author first name(for example -> 'dy' for 'Randy Morales'):");
        String endLetters = br.readLine();

        this.authorService.getAllAuthorsByFirstNameEndingWith(endLetters).forEach(System.out::println);
    }

    private void getBooksWithTitleContainCurrText() throws IOException {
        System.out.println("Please, Enter the text which to be search in book title(for example -> 'sk':");

        String text = br.readLine();

        this.bookService.getAllByTitleContains(text).forEach(System.out::println);
    }

    private void printDashRow() {
        System.out.println("---------------------------------------------------------");
    }
}
