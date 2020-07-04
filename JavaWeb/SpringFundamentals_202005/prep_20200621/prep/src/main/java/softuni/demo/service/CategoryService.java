package softuni.demo.service;

import softuni.demo.model.entity.Category;
import softuni.demo.model.entity.CategoryName;

public interface CategoryService {
    void initCategories();

    Category getCategoryByName(CategoryName category);
}
