package homework.bookshopsystem.serveces.impl;

import homework.bookshopsystem.entities.Author;
import homework.bookshopsystem.repositories.AuthorRepository;
import homework.bookshopsystem.serveces.AuthorService;
import homework.bookshopsystem.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final static String USER_DIR = System.getProperty("user.dir");
    private final static String AUTHOR_FILE_PATH = "\\src\\main\\resources\\files\\authors.txt";
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthor() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authors = this.fileUtil.fileContent(USER_DIR + AUTHOR_FILE_PATH);

        for (String s : authors) {
            String[] params = s.split("\\s+");
            Author author = new Author();
            author.setFirstName(params[0]);
            author.setLastName(params[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<String> getAllAuthorsOrderByBooksCount() {
        return this.authorRepository
                .findAuthorsByOrOrderByBooksDesc()
                .stream()
                .map(a -> String.format("|%12s %-12s|%12d|", a.getFirstName(), a.getLastName(), a.getBooks().size()))
                .collect(Collectors.toList());
    }
}
