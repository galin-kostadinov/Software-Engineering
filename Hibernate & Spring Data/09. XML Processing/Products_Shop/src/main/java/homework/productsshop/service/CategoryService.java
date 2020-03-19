package homework.productsshop.service;

import homework.productsshop.domain.dto.seed.CategorySeedDto;
import homework.productsshop.domain.dto.view.CategorySpecificationViewRootDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categorySeedDtos);

    CategorySpecificationViewRootDto getCategoriesSpecification();
}
