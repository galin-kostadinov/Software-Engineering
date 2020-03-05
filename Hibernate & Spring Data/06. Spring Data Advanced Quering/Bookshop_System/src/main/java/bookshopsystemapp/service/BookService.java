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
}
