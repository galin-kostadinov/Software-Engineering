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
            System.out.println("Enter 8 for 'Book Titles Search' by criteria");
            System.out.println("Enter 9 for 'Count Books' by criteria");
            System.out.println("Enter 10 for 'Total Book Copies' by author");
            System.out.println("Enter 11 for 'Reduced Book'");
            System.out.println("Enter 12 to 'Increase Book Copies'");
            System.out.println("Enter 13 to 'Remove Books' by criteria");

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
                case 8:
                    getBooksTitleByAuthorName();
                    break;
                case 9:
                    getCountBooksBySizeOfTitle();
                    break;
                case 10:
                    getTotalBookCopies();
                    break;
                case 11:
                    getBookInformationByTitle();
                    break;
                case 12:
                    increaseBookCopies();
                    break;
                case 13:
                    removeBookByCopiesCount();
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

    private void getBooksTitleByAuthorName() throws IOException {
        System.out.println("The output will be random for every new database.");
        System.out.println("Please, Enter a part of Author Last name(for example -> 'Ric':");
        String lastName = br.readLine();

        this.bookService.getAllBooksTitlesByAuthorFirstName(lastName).forEach(System.out::println);
    }

    private void getCountBooksBySizeOfTitle() throws IOException {
        System.out.println("Please, Enter a number(Title size):");
        Integer count = Integer.parseInt(br.readLine());

        System.out.println(this.bookService.findAllBooksByTitleCount(count));
    }

    private void getTotalBookCopies() {
        this.bookService.getAllTotalCopiesGroupByAuthor().forEach(System.out::println);
    }

    private void getBookInformationByTitle() throws IOException {
        System.out.println("Please, Enter the book title:");
        String title = br.readLine();

        System.out.println(this.bookService.getBookDetailsByTitle(title));
    }

    private void increaseBookCopies() throws IOException {
        System.out.println("Please, Enter the book released date in format dd-MMM-yyyy(for example -> '12 Oct 2005'):");
        String date = br.readLine();
        System.out.println("Please, Enter the increment value:");
        int count = Integer.parseInt(br.readLine());

        System.out.println(this.bookService.updateBookCopiesCount(date, count));
    }

    private void removeBookByCopiesCount() throws IOException {
        System.out.println("Please, Enter the count of book copies. Books with copies count less than given will be deleted:");
        int count = Integer.parseInt(br.readLine());

        System.out.println(this.bookService.deleteBooksWithCopiesLessThan(count));
    }

    private void printDashRow() {
        System.out.println("---------------------------------------------------------");
    }
}
