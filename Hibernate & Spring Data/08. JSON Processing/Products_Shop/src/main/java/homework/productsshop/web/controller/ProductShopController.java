package homework.productsshop.web.controller;

import com.google.gson.Gson;
import homework.productsshop.domain.dto.*;
import homework.productsshop.domain.dto.seed.CategorySeedDto;
import homework.productsshop.domain.dto.seed.ProductSeedDto;
import homework.productsshop.domain.dto.seed.UserSeedDto;
import homework.productsshop.service.CategoryService;
import homework.productsshop.service.ProductService;
import homework.productsshop.service.UserService;
import homework.productsshop.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class ProductShopController implements CommandLineRunner {
    private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/main/resources/json/";
    private static final String SEED_USERS_JSON = RESOURCES_PATH + "seed/users.json";
    private static final String SEED_CATEGORIES_JSON = RESOURCES_PATH + "seed/categories.json";
    private static final String SEED_PRODUCTS_JSON = RESOURCES_PATH + "seed/products.json";
    private static final String OUTPUT_PRODUCTS_IN_RANGE_JSON = RESOURCES_PATH + "output/products-in-range.json";
    private static final String OUTPUT_USERS_SOLD_PRODUCTS_JSON = RESOURCES_PATH + "output/users-sold-products.json";
    private static final String OUTPUT_CATEGORIES_BY_PRODUCTS_JSON = RESOURCES_PATH + "output/categories-by-products.json";
    private static final String OUTPUT_USERS_AND_PRODUCTS_JSON = RESOURCES_PATH + "output/users-and-products.json";
    private static final String REPORT = "::The report was successfully exported: ";
    private static final String WAIT ="!NB:::Some of the procedures will take more time. Please, wait several seconds.:::";

    private final Gson gson;
    private final FileUtil fileUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductShopController(Gson gson, FileUtil fileUtil, UserService userService, CategoryService categoryService, ProductService productService) {
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println(WAIT);
            System.out.println("------------------------------------------");
            System.out.println("Enter 1: 'Seed the Database'");
            System.out.println("Enter 2: 'Products In Range'");
            System.out.println("Enter 3: 'Successfully Sold Products'");
            System.out.println("Enter 4: 'Categories By Products Count'");
            System.out.println("Enter 5: 'Users and Products'");
            System.out.println("Enter 0: EXIT");
            System.out.println("------------------------------------------");
            System.out.println("Please, enter your choice:");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    this.seedData();
                    break;
                case 2:
                    getProductsInRange();
                    System.out.println(REPORT + OUTPUT_PRODUCTS_IN_RANGE_JSON);
                    break;
                case 3:
                    getAllSellersWithSoldProduct();
                    System.out.println(REPORT + OUTPUT_USERS_SOLD_PRODUCTS_JSON);
                    break;
                case 4:
                    categoriesByProductsCount();
                    System.out.println(REPORT + OUTPUT_CATEGORIES_BY_PRODUCTS_JSON);
                    break;
                case 5:
                    usersAndProducts();
                    System.out.println(REPORT + OUTPUT_USERS_AND_PRODUCTS_JSON);
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;
            }
        }
    }

    private void seedData() throws IOException {
        this.seedUsers();
        this.seedCategories();
        this.seedProduct();
    }

    private void seedUsers() throws IOException {
        String content = this.fileUtil.readContent(SEED_USERS_JSON);
        UserSeedDto[] userSeedDtos = this.gson.fromJson(content, UserSeedDto[].class);
        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException {
        String content = this.fileUtil.readContent(SEED_CATEGORIES_JSON);
        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(content, CategorySeedDto[].class);
        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProduct() throws IOException {
        String content = this.fileUtil.readContent(SEED_PRODUCTS_JSON);
        ProductSeedDto[] productSeedDtos = this.gson.fromJson(content, ProductSeedDto[].class);
        this.productService.seedProducts(productSeedDtos);
    }

    private void getProductsInRange() throws IOException {
        BigDecimal lowerPrice = BigDecimal.valueOf(500);
        BigDecimal highestPrice = BigDecimal.valueOf(1000);

        List<ProductInRangeDto> productInRangeDtoList = this.productService.getAllProductInRangeWithoutBuyer(lowerPrice, highestPrice);

        String productInRangeJson = this.gson.toJson(productInRangeDtoList);

        this.fileUtil.writeContent(productInRangeJson, OUTPUT_PRODUCTS_IN_RANGE_JSON);
    }

    private void getAllSellersWithSoldProduct() throws IOException {
        List<UserSoldProductsDto> userSoldProductsDtoList = this.userService.getAllUsersWithSoldProducts();

        String userSoldProductsJson = this.gson.toJson(userSoldProductsDtoList);

        this.fileUtil.writeContent(userSoldProductsJson, OUTPUT_USERS_SOLD_PRODUCTS_JSON);
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategorySpecificationDto> categorySpecificationDtos = this.categoryService.getCategoriesSpecification();

        String specificationJson = this.gson.toJson(categorySpecificationDtos);

        this.fileUtil.writeContent(specificationJson, OUTPUT_CATEGORIES_BY_PRODUCTS_JSON);
    }

    private void usersAndProducts() throws IOException {
        UsersCountWithProductsDto usersCountWithProductsDtos = this.userService.getUsersCountWithSoldProducts();

        String specificationJson = this.gson.toJson(usersCountWithProductsDtos);

        this.fileUtil.writeContent(specificationJson, OUTPUT_USERS_AND_PRODUCTS_JSON);
    }
}
