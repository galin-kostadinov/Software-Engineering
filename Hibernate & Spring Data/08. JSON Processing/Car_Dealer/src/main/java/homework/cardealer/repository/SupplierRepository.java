package homework.cardealer.repository;

import homework.cardealer.domain.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> getSupplierByName(String name);

    @Query(value = "SELECT s FROM Supplier s JOIN s.parts WHERE s.importer = false group by s.id")
    List<Supplier> getAllLocalSuppliers();
}