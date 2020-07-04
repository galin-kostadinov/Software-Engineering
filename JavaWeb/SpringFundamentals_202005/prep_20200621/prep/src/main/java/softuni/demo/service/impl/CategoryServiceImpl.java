package softuni.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.data.CategoryRepository;
import softuni.demo.model.entity.Category;
import softuni.demo.model.entity.CategoryName;
import softuni.demo.service.CategoryService;

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
