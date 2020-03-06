package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import bookshopsystemapp.dto.book.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(final EditionType editionType, final Integer integer);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContains(String text);

    @Query(value = "SELECT b FROM books b JOIN b.author a WHERE a.lastName LIKE :wildcard")
    List<Book> findBooksByAuthorStartsWith(@Param(value = "wildcard") String wildcard);

    @Query(value = "SELECT COUNT(b)  FROM books AS b WHERE LENGTH(b.title) > :count")
    Integer findAllByTitleCount(@Param(value = "count") Integer count);

    @Query(value = "SELECT b.author.firstName, b.author.lastName, SUM(b.copies) as total_count FROM books AS b GROUP BY b.author" +
            " ORDER BY total_count DESC")
    List<Object[]> getAllTotalCopiesGroupByAuthor();

    ReducedBook getBookByTitle(String title);

    @Modifying
    @Query(value = "UPDATE books AS b SET b.copies = b.copies + :incrementValue WHERE b.releaseDate > :date")
    Integer updateBookCopiesCount(@Param("date") LocalDate date, @Param("incrementValue") int incrementValue);

    @Modifying
    @Query(value = "DELETE FROM books AS b  WHERE b.copies < :count")
    Integer deleteBooksWithCopiesLessThan(@Param("count") int count);
}
