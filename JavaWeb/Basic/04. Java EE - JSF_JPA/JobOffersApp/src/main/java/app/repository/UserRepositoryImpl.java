package app.repository;

import app.domain.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        this.entityManager.getTransaction().begin();
        List<User> users = this.entityManager.createQuery("select u from User u " +
                "where u.username =:username and u.password=:password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        this.entityManager.getTransaction().commit();
        return users.isEmpty() ? null : users.get(0);
    }
}
