package app.web.bean;

import app.domain.model.binding.UserLoginBinding;
import app.domain.model.service.UserServiceModel;
import app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean extends BaseBean {
    private UserService userService;
    private UserLoginBinding user;

    public LoginBean() {
    }

    @Inject
    public LoginBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        this.user = new UserLoginBinding();
    }


    public void login() {
        UserServiceModel user = this.userService
                .findByUsernameAndPassword(this.user.getUsername(), DigestUtils.sha256Hex(this.user.getPassword()));

        if (user == null) {
            this.redirect("/login");
        }else{
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("username", user.getUsername());
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
