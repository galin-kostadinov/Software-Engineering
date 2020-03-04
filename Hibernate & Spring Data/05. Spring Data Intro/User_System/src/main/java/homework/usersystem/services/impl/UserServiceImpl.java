package homework.usersystem.services.impl;

import homework.usersystem.entities.User;
import homework.usersystem.repository.UserRepository;
import homework.usersystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getUsersByEmailProvider(String provider) {
        return userRepository
                .findAllByEmailEndingWith(provider)
                .stream()
                .map(u -> String.format("%s %s", u.getUsername(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public void setToDeletedInactiveUsers(LocalDateTime date) {
        this.userRepository
                .findAllByLastTimeLoggedInBefore(date)
                .forEach(u -> u.setIsDeleted(true));
    }

    @Override
    public long deleteInactiveUsers() {
        return this.userRepository.deleteAllByIsDeletedIs(true);
    }

    @Override
    public void save(final User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public long getUsersCount() {
        return this.userRepository.count();
    }
}
