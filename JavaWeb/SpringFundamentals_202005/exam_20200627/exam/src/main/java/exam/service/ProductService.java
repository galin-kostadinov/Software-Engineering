package exam.service;

import exam.model.service.ProductServiceModel;

import java.util.Arrays;
import java.util.List;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    ProductServiceModel getById(String id);

    List<ProductServiceModel> getFoods();

    List<ProductServiceModel> getDrinks();

    List<ProductServiceModel> getHouseholds();

    List<ProductServiceModel> getOthers();

    void buyAll();

    void buyProduct(String id);
}
