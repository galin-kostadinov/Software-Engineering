package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserNameAgeSoldProductsViewDto implements Serializable {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private Integer age;

    @XmlElement(name = "sold-products")
    SoldProductsCountNamePriceViewDto soldProducts;

    public UserNameAgeSoldProductsViewDto() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SoldProductsCountNamePriceViewDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsCountNamePriceViewDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
