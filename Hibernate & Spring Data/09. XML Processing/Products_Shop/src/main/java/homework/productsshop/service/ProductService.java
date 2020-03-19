package homework.productsshop.service;

import homework.productsshop.domain.dto.seed.ProductSeedDto;
import homework.productsshop.domain.dto.view.ProductInRangeViewRootDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedProducts(List<ProductSeedDto> productSeedDtos);

    ProductInRangeViewRootDto getAllProductInRangeWithoutBuyer(BigDecimal lowerPrice, BigDecimal higherPrice);

}
