package homework.productsshop.domain.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto implements Serializable {

    @XmlElement(name = "user")
    private List<UserSeedDto> users;

    public UserSeedRootDto() {
    }

    public List<UserSeedDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeedDto> users) {
        this.users = users;
    }
}
