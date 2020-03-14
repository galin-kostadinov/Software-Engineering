package homework.productsshop.service;

import homework.productsshop.domain.dto.ProductInRangeDto;
import homework.productsshop.domain.dto.seed.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductInRangeDto> getAllProductInRangeWithoutBuyer(BigDecimal lowerPrice, BigDecimal higherPrice);
}
