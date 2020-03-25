package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        StringBuilder sb = new StringBuilder();

        List<Category> categories = this.categoryRepository
                .findAllOrderByItemsCountDescAndPriceSum();

        categories.forEach(c -> {
            sb.append(String.format("Category: %s", c.getName())).append(System.lineSeparator());

            c.getItems().forEach(item -> {
                sb.append(String.format("--- Item Name: %s", item.getName())).append(System.lineSeparator());
                sb.append(String.format("--- Item Price: %s", item.getPrice())).append(System.lineSeparator());
                sb.append(System.lineSeparator());
            });
        });

        return sb.toString().trim();
    }

    @Override
    public Category getCategoryByName(String name) {
        Category category = this.categoryRepository.findByName(name).orElse(null);

        if (category == null) {
            addCategory(name);
            category = this.categoryRepository.findByName(name).orElse(null);
        }

        return category;
    }

    private void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        this.categoryRepository.saveAndFlush(category);
    }
}
