package repository;

import domain.entity.User;

import java.util.List;

public interface UserRepository {
    void save(User user);

    void update(User user);

    User findById(String id);

    User findByUserNameAndPassword(String username, String password);

    List<User> findAll();
}
