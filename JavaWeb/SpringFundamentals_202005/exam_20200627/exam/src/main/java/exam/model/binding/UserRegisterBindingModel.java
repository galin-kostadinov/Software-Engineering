package exam.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegisterBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters.")
    @NotNull(message = "Username cannot be null.")
    @NotBlank(message = "Username is mandatory.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters.")
    @NotNull(message = "Password cannot be null.")
    @NotBlank(message = "Password is mandatory.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters.")
    @NotNull(message = "Password cannot be null.")
    @NotBlank(message = "Password is mandatory.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email(message = "Email must be valid.")
    @NotNull(message = "Email cannot be null.")
    @NotBlank(message = "Email is mandatory.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
