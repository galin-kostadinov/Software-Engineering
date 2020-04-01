package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMakeAndModelAndKilometers(String make, String Model, Integer kilometers);

    @Query("SELECT c FROM Car c JOIN c.pictures p GROUP BY c.id ORDER BY p.size DESC, c.make ASC ")
    List<Car> getCarsOrderByPicturesCountThenByMake();
}
