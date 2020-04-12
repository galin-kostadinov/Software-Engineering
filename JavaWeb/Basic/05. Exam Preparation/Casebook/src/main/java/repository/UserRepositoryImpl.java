package repository;

import domain.entity.User;

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
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findById(String id) {
        List<User> users = entityManager
                .createQuery("select u from User u where u.id=:id", User.class)
                .setParameter("id", id)
                .getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        List<User> users = entityManager.createQuery("select u from User u where u.username=:username and u.password=:password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }
}
