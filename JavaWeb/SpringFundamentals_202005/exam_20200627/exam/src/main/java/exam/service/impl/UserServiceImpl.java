package exam.service.impl;

import exam.data.UserRepository;
import exam.model.entity.User;
import exam.model.service.UserLoginServiceModel;
import exam.model.service.UserRegisterServiceModel;
import exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void register(UserRegisterServiceModel userRegisterServiceModel) {
        User user = this.modelMapper.map(userRegisterServiceModel, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        User user = this.userRepository
                .findByUsernameAndPassword(userLoginServiceModel.getUsername(), userLoginServiceModel.getPassword())
                .orElse(null);

        return user != null;
    }
}
