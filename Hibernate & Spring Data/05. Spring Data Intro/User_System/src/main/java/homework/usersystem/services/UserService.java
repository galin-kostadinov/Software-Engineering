package homework.usersystem.services;

import homework.usersystem.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    List<String> getUsersByEmailProvider(String provider);

    void setToDeletedInactiveUsers(LocalDateTime date);

    long deleteInactiveUsers();

    void save(final User user);

    long getUsersCount();
}
