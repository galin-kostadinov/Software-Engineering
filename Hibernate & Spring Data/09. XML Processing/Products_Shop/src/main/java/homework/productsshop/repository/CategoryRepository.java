package homework.productsshop.repository;

import homework.productsshop.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c.name, count(p) as pc, avg(p.price), sum(p.price)" +
            " FROM Category c JOIN c.products p" +
            " GROUP BY c.id" +
            " ORDER BY pc desc ")
    List<Object[]> getCategoriesSpecification();

}
