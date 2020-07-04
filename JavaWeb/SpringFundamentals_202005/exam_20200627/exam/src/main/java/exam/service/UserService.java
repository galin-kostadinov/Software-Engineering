package exam.service;


import exam.model.service.UserLoginServiceModel;
import exam.model.service.UserRegisterServiceModel;

public interface UserService {
    void register(UserRegisterServiceModel userRegisterServiceModel);

    boolean login(UserLoginServiceModel userLoginServiceModel);
}
