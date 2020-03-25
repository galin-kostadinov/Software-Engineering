package alararestaurant.repository;

import alararestaurant.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT o FROM Order AS o JOIN o.employee AS e JOIN o.orderItems AS oi JOIN e.position AS ep " +
            "WHERE ep.name = 'Burger Flipper' ORDER BY e.name, o.id")
    List<Order> findByEmployeePositionNameOrderByEmployeeNameAndOrderId();
}
