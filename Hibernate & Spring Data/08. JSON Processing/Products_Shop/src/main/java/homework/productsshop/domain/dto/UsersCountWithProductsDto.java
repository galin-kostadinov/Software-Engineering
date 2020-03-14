package homework.productsshop.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsersCountWithProductsDto implements Serializable {
    @Expose
    private Long usersCount;
    @Expose
    private List<UserNameAgeSoldProductsDto> users;

    public UsersCountWithProductsDto() {
        users = new ArrayList<>();
    }

    public Long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Long usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserNameAgeSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserNameAgeSoldProductsDto> users) {
        this.users = users;
    }
}
