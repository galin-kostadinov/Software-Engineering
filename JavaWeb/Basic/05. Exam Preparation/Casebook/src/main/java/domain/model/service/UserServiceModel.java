package domain.model.service;

import java.io.Serializable;
import java.util.List;

public class UserServiceModel implements Serializable {
    private String id;
    private String username;
    private String password;
    private String gender;
    private List<UserServiceModel> friends;

    public UserServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<UserServiceModel> getFriends() {
        return friends;
    }

    public void setFriends(List<UserServiceModel> friends) {
        this.friends = friends;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        return this.getId().equals(((UserServiceModel) obj).getId());
    }
}
