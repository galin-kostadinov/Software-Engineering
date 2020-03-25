package alararestaurant.domain.dtos.seed;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ItemSeedJsonDto implements Serializable {
    @Expose
    private String name;

    @Expose
    private String category;

    @Expose
    private BigDecimal price;

    public ItemSeedJsonDto() {
    }

    @NotNull
    @Length(min = 3, max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Length(min = 3, max = 30)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @NotNull
    @DecimalMin(value = "0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
