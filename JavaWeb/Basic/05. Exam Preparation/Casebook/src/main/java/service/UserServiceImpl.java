package service;

import domain.entity.User;
import domain.model.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import repository.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel user) {
        this.userRepository.save(this.modelMapper.map(user, User.class));
    }

    @Override
    public UserServiceModel getByUserNameAndPassword(String username, String password) {
        User user = this.userRepository.findByUserNameAndPassword(username, password);

        if (user == null) {
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel getById(String id) {
        User user = this.userRepository.findById(id);

        if (user == null) {
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> getAll() {
        return this.userRepository.findAll()
                .stream()
                .map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addFriend(UserServiceModel userServiceModel) {
        this.userRepository.update(this.modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public void removeFriend(UserServiceModel userServiceModel) {
        this.userRepository.update(this.modelMapper.map(userServiceModel, User.class));
    }
}
