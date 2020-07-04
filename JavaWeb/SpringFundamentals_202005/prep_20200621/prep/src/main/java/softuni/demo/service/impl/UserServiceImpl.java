package softuni.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.data.UserRepository;
import softuni.demo.model.entity.User;
import softuni.demo.model.service.UserLoginServiceModel;
import softuni.demo.model.service.UserRegisterServiceModel;
import softuni.demo.service.UserService;

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
