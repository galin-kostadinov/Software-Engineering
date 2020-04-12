package web.bean;

import domain.model.binding.UserLoginBinding;
import domain.model.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean extends BaseBean {
    private UserLoginBinding user;
    private UserService userService;

    public LoginBean() {
    }

    @Inject
    public LoginBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    void init() {
        this.user = new UserLoginBinding();
    }

    public void login() {
        UserServiceModel userInDb =
                this.userService.getByUserNameAndPassword(user.getUsername(), DigestUtils.sha256Hex(this.user.getPassword()));

        if (userInDb == null) {
            this.redirect("/login");
        } else {
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("username", userInDb.getUsername());
            sessionMap.put("userId", userInDb.getId());
            this.redirect("/home");
        }
    }

    public UserLoginBinding getUser() {
        return user;
    }

    public void setUser(UserLoginBinding user) {
        this.user = user;
    }
}
