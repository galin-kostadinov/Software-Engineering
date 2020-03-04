package homework.usersystem.repository;

import homework.usersystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmailEndingWith(String provider);

    List<User> findAllByLastTimeLoggedInBefore(LocalDateTime localDate);

    long deleteAllByIsDeletedIs(Boolean isDeleted);
}
