package homework.cardealer.repository;

import homework.cardealer.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT c FROM Customer c ORDER BY c.birthDate, c.youngDriver")
    List<Customer> getAllOrderByBirthDateAndYoungDriver();

    @Query(value = "SELECT c.name, s.size AS cc, SUM(pr.price) AS tp " +
            "FROM Customer c " +
            "JOIN c.purchases s " +
            "JOIN s.car cr " +
            "JOIN cr.parts pr " +
            "WHERE c.purchases.size > 0 " +
            "GROUP BY c.id " +
            "ORDER BY tp DESC, cc DESC" )
    List<Object[]> getAllCustomersNameBoughtCarsAndSpendMoney();
}
