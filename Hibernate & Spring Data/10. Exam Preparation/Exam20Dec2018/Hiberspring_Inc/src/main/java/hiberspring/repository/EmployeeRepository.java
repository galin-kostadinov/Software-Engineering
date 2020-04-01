package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e FROM Employee e JOIN e.card JOIN e.branch b JOIN b.products p " +
            " WHERE p.size > 0 ORDER BY CONCAT(e.firstName, ' ', e.lastName), (e.position) DESC ")
    List<Employee> findAllByBranchContainingProductOrderByFullName();
}
