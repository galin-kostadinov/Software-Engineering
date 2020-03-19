package homework.productsshop.web.controller;

import homework.productsshop.domain.dto.seed.*;
import homework.productsshop.domain.dto.view.*;
import homework.productsshop.service.CategoryService;
import homework.productsshop.service.ProductService;
import homework.productsshop.service.UserService;
import homework.productsshop.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import static homework.productsshop.constant.PathConstant.*;

@Component
public class ProductShopController implements CommandLineRunner {
    private static final String REPORT = "::The report was successfully exported: ";
    private static final String WAIT = "!NB:::Some of the procedures will take more time. Please, wait several seconds.:::";

    private final XmlParser xmlParser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductShopController(XmlParser xmlParser, UserService userService, CategoryService categoryService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------------------");
        System.out.println(WAIT);
        System.out.println("------------------------------------------");
        System.out.println("Enter 0: 'Seed the Database'");
        System.out.println("Enter 1: 'Products In Range'");
        System.out.println("Enter 2: 'Successfully Sold Products'");
        System.out.println("Enter 3: 'Categories By Products Count'");
        System.out.println("Enter 4: 'Users and Products'");
        System.out.println("Enter 9: EXIT");
        System.out.println("------------------------------------------");

        int choice;
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("Please, enter your choice:");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    this.seedData();
                    break;
                case 1:
                    getProductsInRange();
                    System.out.println(REPORT + OUTPUT_PRODUCTS_IN_RANGE_XML);
                    break;
                case 2:
                    getAllSellersWithSoldProduct();
                    System.out.println(REPORT + OUTPUT_USERS_SOLD_PRODUCTS_XML);
                    break;
                case 3:
                    categoriesByProductsCount();
                    System.out.println(REPORT + OUTPUT_CATEGORIES_BY_PRODUCTS_XML);
                    break;
                case 4:
                    usersAndProducts();
                    System.out.println(REPORT + OUTPUT_USERS_AND_PRODUCTS_XML);
                    break;
                case 9:
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
        UserSeedRootDto dtos = this.xmlParser.objectFromFile(UserSeedRootDto.class, SEED_USERS_XML);

        this.userService.seedUsers(dtos.getUsers());
    }

    private void seedCategories() throws IOException {
        CategorySeedRootDto dtos = this.xmlParser.objectFromFile(CategorySeedRootDto.class, SEED_CATEGORIES_XML);

        this.categoryService.seedCategories(dtos.getCategories());
    }

    private void seedProduct() throws IOException {
        ProductSeedRootDto dtos = this.xmlParser.objectFromFile(ProductSeedRootDto.class, SEED_PRODUCTS_XML);

        this.productService.seedProducts(dtos.getProducts());
    }

    private void getProductsInRange() throws IOException {
        BigDecimal lowerPrice = BigDecimal.valueOf(500);
        BigDecimal highestPrice = BigDecimal.valueOf(1000);

        ProductInRangeViewRootDto dtos = this.productService.getAllProductInRangeWithoutBuyer(lowerPrice, highestPrice);

        this.xmlParser.objectToFile(dtos, OUTPUT_PRODUCTS_IN_RANGE_XML);
    }

    private void getAllSellersWithSoldProduct() throws IOException {
        UserSoldProductsViewRootDto dtos = this.userService.getAllUsersWithSoldProducts();

        this.xmlParser.objectToFile(dtos, OUTPUT_USERS_SOLD_PRODUCTS_XML);
    }

    private void categoriesByProductsCount() throws IOException {
        CategorySpecificationViewRootDto dtos = this.categoryService.getCategoriesSpecification();

        this.xmlParser.objectToFile(dtos, OUTPUT_CATEGORIES_BY_PRODUCTS_XML);
    }

    private void usersAndProducts() throws IOException {
        UsersCountWithProductsViewRootDto dtos = this.userService.getUsersCountWithSoldProducts();

        this.xmlParser.objectToFile(dtos, OUTPUT_USERS_AND_PRODUCTS_XML);
    }
}
