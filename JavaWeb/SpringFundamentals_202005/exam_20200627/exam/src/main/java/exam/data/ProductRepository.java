package exam.data;

import exam.model.entity.CategoryName;
import exam.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByCategoryCategory(CategoryName category);
}
