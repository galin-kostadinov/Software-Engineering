package softuni.demo.service;

import softuni.demo.model.service.UserLoginServiceModel;
import softuni.demo.model.service.UserRegisterServiceModel;

public interface UserService {
    void register(UserRegisterServiceModel userRegisterServiceModel);

    boolean login(UserLoginServiceModel userLoginServiceModel);
}
