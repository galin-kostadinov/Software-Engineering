package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> getAllBookTitlesByAgeRestriction(AgeRestriction ageRestriction);

    List<String> getAllBookWithGoldenEditionTypeAndCopiesLessThan5000();

    List<String> getBookInPriceRange();

    List<String> getBookNotReleasedInCurrYear(String year);

    List<String> getAllBooksBefore(String date);

    List<String> getAllByTitleContains(String text);

    List<String> getAllBooksTitlesByAuthorFirstName(String text);

    Integer findAllBooksByTitleCount(Integer count);

    List<String> getAllTotalCopiesGroupByAuthor();

    String getBookDetailsByTitle(String title);

    Integer updateBookCopiesCount(String date, int count);

    Integer deleteBooksWithCopiesLessThan(int count);
}
