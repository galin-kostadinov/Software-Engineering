package softuni.demo.model.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String budget;

    public UserRegisterBindingModel() {
    }

    @Size(min = 2, message = "Username must be min 2 characters length.")
    @NotBlank(message = "Username is mandatory.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 2, message = "Password must be min 2 characters length.")
    @NotBlank(message = "Password is mandatory.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Size(min = 2, message = "Password must be min 2 characters length.")
    @NotBlank(message = "Password is mandatory.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email(message = "Email must be valid.")
    @NotBlank(message = "Email is mandatory.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DecimalMin(value = "0", message = "Budget cannot be negative value.")
    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
