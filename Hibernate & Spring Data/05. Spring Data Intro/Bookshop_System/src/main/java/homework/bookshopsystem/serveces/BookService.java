package homework.bookshopsystem.serveces;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> findAllTitles();

    List<String> findAllAuthors();

    List<String> getAllBooksByGeorgePowell();
}