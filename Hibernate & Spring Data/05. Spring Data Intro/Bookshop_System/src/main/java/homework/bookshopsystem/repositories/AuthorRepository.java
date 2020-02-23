package homework.bookshopsystem.repositories;

import homework.bookshopsystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value =
           "SELECT a.id, a.first_name, a.last_name, COUNT(b.author_id) AS books_count\n" +
                   "FROM books AS b\n" +
                   "JOIN authors AS a ON b.author_id = a.id\n" +
                   "GROUP BY b.author_id\n" +
                   "ORDER BY books_count DESC;", nativeQuery = true)
    List<Author> findAuthorsByOrOrderByBooksDesc();
}
