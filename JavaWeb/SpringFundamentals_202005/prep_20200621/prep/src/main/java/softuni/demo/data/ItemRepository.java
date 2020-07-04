package softuni.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
