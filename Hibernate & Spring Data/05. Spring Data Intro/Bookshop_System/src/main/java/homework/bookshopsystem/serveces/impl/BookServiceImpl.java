package homework.bookshopsystem.serveces.impl;

import homework.bookshopsystem.entities.*;
import homework.bookshopsystem.repositories.AuthorRepository;
import homework.bookshopsystem.repositories.BookRepository;
import homework.bookshopsystem.repositories.CategoryRepository;
import homework.bookshopsystem.serveces.BookService;
import homework.bookshopsystem.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final static String USER_DIR = System.getProperty("user.dir");
    private final static String BOOK_FILE_PATH = "\\src\\main\\resources\\files\\books.txt";

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

        String[] books = this.fileUtil.fileContent(USER_DIR + BOOK_FILE_PATH);

        for (String b : books) {
            String[] params = b.split("\\s+");

            Book book = new Book();
            book.setAuthor(randomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(params[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            book.setCopies(Integer.parseInt(params[2]));

            BigDecimal price = new BigDecimal(params[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();

            for (int i = 5; i < params.length; i++) {
                title.append(params[i]).append(' ');
            }

            book.setTitle(title.toString().trim());

            book.setCategories(randomCategories());

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> findAllTitles() {
        LocalDate localDate = LocalDate.parse("31/12/2000", DateTimeFormatter.ofPattern("d/M/yyyy"));
        return this.bookRepository
                .findAllByReleaseDateAfter(localDate)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthors() {
        LocalDate localDate = LocalDate.parse("1/1/1990", DateTimeFormatter.ofPattern("d/M/yyyy"));

        return this.bookRepository
                .findAllByReleaseDateBefore(localDate)
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet())
                .stream()
                .map(a -> String.format("|%10s %-10s|", a.getFirstName(), a.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksByGeorgePowell() {
        return this.bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
                .stream()
                .map(b -> String.format("|%-25s|%15s|%10d|", b.getTitle(), b.getReleaseDate(), b.getCopies()))
                .collect(Collectors.toList());
    }

    private Author randomAuthor() {
        Random random = new Random();

        int index = random.nextInt((int) this.authorRepository.count()) + 1;

        return this.authorRepository.getOne((long) index);
    }

    private Category randomCategory() {
        Random random = new Random();

        int index = random.nextInt((int) this.categoryRepository.count()) + 1;

        return this.categoryRepository.getOne((long) index);
    }

    private Set<Category> randomCategories() {
        Set<Category> categories = new HashSet<>();

        Random random = new Random();

        int index = random.nextInt((int) this.categoryRepository.count()) + 1;

        for (int i = 0; i < index; i++) {
            categories.add(randomCategory());
        }

        return categories;
    }
}
