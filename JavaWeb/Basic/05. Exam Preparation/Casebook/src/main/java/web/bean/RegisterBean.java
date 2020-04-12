package web.bean;

import domain.model.binding.UserRegisterBinding;
import domain.model.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {
    private UserRegisterBinding user;
    private UserService userService;
    private ModelMapper modelMapper;

    public RegisterBean() {
    }

    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.user = new UserRegisterBinding();
    }

    public void register() {
        if (!this.user.getPassword().equals(this.user.getConfirmPassword())) {
            redirect("/register");
            return;
        }

        UserServiceModel userInDb =
                this.userService.getByUserNameAndPassword(user.getUsername(), DigestUtils.sha256Hex(this.user.getPassword()));

        if (userInDb != null) {
            redirect("/register");
            return;
        }

        this.user.setPassword(DigestUtils.sha256Hex(this.user.getPassword()));
        this.userService.register(this.modelMapper.map(user, UserServiceModel.class));
        this.redirect("/login");

    }

    public UserRegisterBinding getUser() {
        return user;
    }

    public void setUser(UserRegisterBinding user) {
        this.user = user;
    }
}
