package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsViewRootDto {

    @XmlElement(name = "user")
    List<UserSoldProductsViewDto> users;

    public UserSoldProductsViewRootDto() {
    }

    public UserSoldProductsViewRootDto(List<UserSoldProductsViewDto> users) {
        this.users = users;
    }

    public List<UserSoldProductsViewDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSoldProductsViewDto> users) {
        this.users = users;
    }
}
