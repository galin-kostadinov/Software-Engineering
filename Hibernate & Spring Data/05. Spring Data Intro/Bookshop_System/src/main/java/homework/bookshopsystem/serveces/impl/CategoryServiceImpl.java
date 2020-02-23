package homework.bookshopsystem.serveces.impl;

import homework.bookshopsystem.entities.Author;
import homework.bookshopsystem.entities.Category;
import homework.bookshopsystem.repositories.CategoryRepository;
import homework.bookshopsystem.serveces.CategoryService;
import homework.bookshopsystem.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final static String USER_DIR = System.getProperty("user.dir");
    private final static String CATEGORY_FILE_PATH = "\\src\\main\\resources\\files\\categories.txt";
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategory() throws IOException {
        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] categories = this.fileUtil.fileContent(USER_DIR + CATEGORY_FILE_PATH);

        for (String c : categories) {
            Category category = new Category();
            category.setName(c);

            this.categoryRepository.saveAndFlush(category);
        }
    }
}
