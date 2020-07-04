package softuni.demo.model.binding;

import softuni.demo.model.entity.Category;
import softuni.demo.model.entity.CategoryName;
import softuni.demo.model.entity.Gender;
import softuni.demo.model.service.BaseServiceModel;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private CategoryName category;
    private Gender gender;

    public ItemAddBindingModel() {
    }

    @Size(min = 2, message = "Name must be min 2 characters length.")
    @NotBlank(message = "Name is mandatory.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3, message = "Description must be min 3 characters length.")
    @NotBlank(message = "Description is mandatory.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "Price cannot be negative value.")
    @NotNull(message = "Price is mandatory.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "Category is mandatory.")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    @NotNull(message = "Gender is mandatory.")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
