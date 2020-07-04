package exam.data;

import exam.model.entity.Category;
import exam.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByCategory(CategoryName categoryName);
}
