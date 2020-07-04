package exam.service.impl;

import exam.data.CategoryRepository;
import exam.model.entity.Category;
import exam.model.entity.CategoryName;
import exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(c -> {
                        Category category = new Category();
                        category.setCategory(c);
                        category.setDescription(String.format("%s was added.", c.name()));
                        this.categoryRepository.saveAndFlush(category);
                    });
        }
    }

    @Override
    public Category getCategoryByName(CategoryName categoryName) {
        return this.categoryRepository.findByCategory(categoryName);
    }
}
