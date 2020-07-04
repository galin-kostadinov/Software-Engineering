package softuni.demo.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;


    public UserLoginBindingModel() {
    }

    @Size(min = 2, message = "Username must be min 2 characters length.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 2, message = "Password must be min 2 characters length.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
