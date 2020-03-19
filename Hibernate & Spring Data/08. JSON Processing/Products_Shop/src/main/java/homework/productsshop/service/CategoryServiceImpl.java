package homework.productsshop.service;

import homework.productsshop.domain.dto.seed.CategorySeedDto;
import homework.productsshop.domain.dto.CategorySpecificationDto;
import homework.productsshop.domain.entity.Category;
import homework.productsshop.repository.CategoryRepository;
import homework.productsshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper, ValidatorUtil validatorUtil, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!this.validatorUtil.isValid(categorySeedDto)) {
                this.validatorUtil
                        .violations(categorySeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));
                continue;
            }

            Category category = this.modelMapper.map(categorySeedDto, Category.class);

            this.categoryRepository.saveAndFlush(category);
        }
    }

    @Override
    public List<CategorySpecificationDto> getCategoriesSpecification() {
        List<Object[]> categoriesSpecification = this.categoryRepository.getCategoriesSpecification();

        List<CategorySpecificationDto> categorySpecificationDtos = new ArrayList<>();

        for (Object[] object : categoriesSpecification) {
            CategorySpecificationDto categorySpecificationDto =
                    new CategorySpecificationDto(object[0].toString(),
                            Long.parseLong(object[1].toString()),
                            new BigDecimal(object[2].toString()),
                            new BigDecimal(object[3].toString()));

            categorySpecificationDtos.add(categorySpecificationDto);
        }

        return categorySpecificationDtos;
    }
}
