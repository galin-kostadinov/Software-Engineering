package service;

import domain.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel user);

    UserServiceModel getByUserNameAndPassword(String username, String password);

    UserServiceModel getById(String id);

    List<UserServiceModel> getAll();

    void addFriend(UserServiceModel userServiceModel);

    void removeFriend(UserServiceModel userServiceModel);
}
