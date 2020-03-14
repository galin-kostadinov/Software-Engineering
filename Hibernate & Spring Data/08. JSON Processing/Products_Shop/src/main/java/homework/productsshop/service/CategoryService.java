package homework.productsshop.service;

import homework.productsshop.domain.dto.seed.CategorySeedDto;
import homework.productsshop.domain.dto.CategorySpecificationDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] categorySeedDtos);

    List<CategorySpecificationDto> getCategoriesSpecification();
}
