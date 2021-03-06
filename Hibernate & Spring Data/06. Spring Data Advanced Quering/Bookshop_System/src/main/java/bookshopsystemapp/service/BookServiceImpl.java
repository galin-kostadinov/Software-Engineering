package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.dto.book.ReducedBook;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final static String USER_DIR = System.getProperty("user.dir");
    private final static String BOOKS_FILE_PATH = "\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(USER_DIR + BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    @Override
    public List<String> getAllBookTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository
                .findAllByAgeRestriction(ageRestriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookWithGoldenEditionTypeAndCopiesLessThan5000() {
        return this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(b -> b.getTitle())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookInPriceRange() {
        return this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream()
                .map(b -> String.format("%s - $%.2f", b.getTitle(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookNotReleasedInCurrYear(String year) {
        LocalDate localDateStart = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(year + "-01-01"));
        LocalDate localDateEnd = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(year + "-12-31"));

        return this.bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(localDateStart, localDateEnd)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksBefore(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDateBefore = LocalDate.parse(date, df);

        return this.bookRepository
                .findAllByReleaseDateBefore(localDateBefore)
                .stream()
                .map(b -> String.format("%s %s %.2f", b.getTitle(), b.getEditionType(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllByTitleContains(String text) {
        return this.bookRepository
                .findAllByTitleContains(text)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksTitlesByAuthorFirstName(String text) {
        return this.bookRepository
                .findBooksByAuthorStartsWith(text + "%")
                .stream()
                .map(b -> String.format("%s (%s %s)", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer findAllBooksByTitleCount(Integer count) {
        return this.bookRepository.findAllByTitleCount(count);
    }

    @Override
    public List<String> getAllTotalCopiesGroupByAuthor() {
        return this.bookRepository
                .getAllTotalCopiesGroupByAuthor()
                .stream()
                .map(b -> String.format("%s %s - %s",
                        b[0], b[1], b[2]))
                .collect(Collectors.toList());
    }

    @Override
    public String getBookDetailsByTitle(String title) {
        ReducedBook reducedBook = this.bookRepository.getBookByTitle(title);

        return reducedBook != null ? reducedBook.toString() : "Book not found.";
    }

    @Override
    public Integer updateBookCopiesCount(String date, int count) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate localDateAfter = LocalDate.parse(date, df);

        return this.bookRepository.updateBookCopiesCount(localDateAfter, count) * count;
    }

    @Override
    public Integer deleteBooksWithCopiesLessThan(int count) {
        return this.bookRepository.deleteBooksWithCopiesLessThan(count);
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }
}
