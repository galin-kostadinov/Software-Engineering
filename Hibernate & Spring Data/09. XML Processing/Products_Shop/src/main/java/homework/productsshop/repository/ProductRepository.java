package homework.productsshop.repository;

import homework.productsshop.domain.entity.Product;
import homework.productsshop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerOrderByPrice(BigDecimal lowestPrice, BigDecimal highestPrice, User buyer);

}
