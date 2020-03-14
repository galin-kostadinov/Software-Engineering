package homework.productsshop.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserNameAgeSoldProductsDto implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    SoldProductsCountNamePriceDto soldProducts;

    public UserNameAgeSoldProductsDto() {

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

    public SoldProductsCountNamePriceDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsCountNamePriceDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
