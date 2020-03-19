package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersCountWithProductsViewRootDto implements Serializable {

    @XmlAttribute(name = "count")
    private Long usersCount;

    @XmlElement(name = "user")
    private List<UserNameAgeSoldProductsViewDto> users;

    public UsersCountWithProductsViewRootDto() {
        users = new ArrayList<>();
    }

    public Long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Long usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserNameAgeSoldProductsViewDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserNameAgeSoldProductsViewDto> users) {
        this.users = users;
    }
}
