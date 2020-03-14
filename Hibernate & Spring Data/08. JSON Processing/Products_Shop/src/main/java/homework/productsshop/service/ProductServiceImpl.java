package homework.productsshop.service;

import homework.productsshop.domain.dto.ProductInRangeDto;
import homework.productsshop.domain.dto.seed.ProductSeedDto;
import homework.productsshop.domain.entity.Category;
import homework.productsshop.domain.entity.Product;
import homework.productsshop.domain.entity.User;
import homework.productsshop.repository.CategoryRepository;
import homework.productsshop.repository.ProductRepository;
import homework.productsshop.repository.UserRepository;
import homework.productsshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        for (ProductSeedDto productSeedDto : productSeedDtos) {
            if (!this.validatorUtil.isValid(productSeedDto)) {
                this.validatorUtil
                        .violations(productSeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            Product product = this.modelMapper.map(productSeedDto, Product.class);

            User seller = this.getRandomSeller();

            while (seller == null) {
                seller = this.getRandomSeller();
            }

            User buyer = this.getRandomBuyer();

            while (buyer != null && buyer.getId().equals(seller.getId())) {
                buyer = this.getRandomBuyer();
            }

            product.setSeller(seller);
            product.setBuyer(buyer);

            this.productRepository.saveAndFlush(product);

            Set<Category> categories = this.getRandomCategories();

            product.setCategories(categories);

            for (Category category : categories) {
                category.getProducts().add(product);
            }
        }
    }

    @Override
    public List<ProductInRangeDto> getAllProductInRangeWithoutBuyer(BigDecimal lowestPrice, BigDecimal highestPrice) {
        List<Product> productEntities = this.productRepository.findAllByPriceBetweenAndBuyerOrderByPrice(lowestPrice, highestPrice, null);

        List<ProductInRangeDto> productInRangeDtos = new ArrayList<>();

        for (Product productEntity : productEntities) {
            ProductInRangeDto productInRangeDto = this.modelMapper.map(productEntity, ProductInRangeDto.class);
            User seller = productEntity.getSeller();
            productInRangeDto.setSeller(String.format("%s %s", seller.getFirstName(), seller.getLastName()));

            productInRangeDtos.add(productInRangeDto);
        }

        return productInRangeDtos;
    }

    private User getRandomSeller() {
        Random random = new Random();
        long id = (long) random.nextInt((int) this.userRepository.count() - 1) + 1;
        return this.userRepository.findById(id).orElse(null);
    }

    private User getRandomBuyer() {
        Random random = new Random();
        long id = (long) random.nextInt((int) this.userRepository.count() - 1) + 1;

        if (id % 4 == 0) {
            return null;
        }

        return this.userRepository.findById(id).orElse(null);
    }

    private Category getRandomCategory() {
        Random random = new Random();
        long id = (long) random.nextInt((int) this.categoryRepository.count() - 1) + 1;

        return this.categoryRepository.findById(id).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Random random = new Random();
        int size = random.nextInt((int) this.categoryRepository.count() - 1) + 1;

        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < size; i++) {
            categories.add(getRandomCategory());
        }

        return categories;
    }
}
