package homework.productsshop.repository;

import homework.productsshop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User as u JOIN u.sellProducts AS p WHERE p.buyer IS NOT NULL " +
            "GROUP BY u.id ORDER BY u.lastName, u.firstName")
    List<User> getAllWithSoldProducts();


}
