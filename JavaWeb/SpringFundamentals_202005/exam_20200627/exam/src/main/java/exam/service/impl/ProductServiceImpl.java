package exam.service.impl;

import exam.data.ProductRepository;
import exam.model.entity.Category;
import exam.model.entity.CategoryName;
import exam.model.entity.Product;
import exam.model.service.ProductServiceModel;
import exam.service.CategoryService;
import exam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        Category category = categoryService.getCategoryByName(productServiceModel.getCategory());
        product.setCategory(category);
        this.productRepository.saveAndFlush(product);
    }

    @Override
    public ProductServiceModel getById(String id) {
        Product item = productRepository.findById(id).orElse(null);
        return this.modelMapper.map(item, ProductServiceModel.class);
    }

    @Override
    public List<ProductServiceModel> getFoods() {
        return this.productRepository
                .findAllByCategoryCategory(CategoryName.FOOD)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductServiceModel> getDrinks() {
        return this.productRepository
                .findAllByCategoryCategory(CategoryName.DRINK)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductServiceModel> getHouseholds() {
        return this.productRepository
                .findAllByCategoryCategory(CategoryName.HOUSEHOLD)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductServiceModel> getOthers() {
        return this.productRepository
                .findAllByCategoryCategory(CategoryName.OTHER)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyAll() {
        this.productRepository.deleteAll();
    }

    @Override
    public void buyProduct(String id) {
        this.productRepository.deleteById(id);
    }
}
