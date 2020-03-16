package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class PartNamePriceViewDto implements Serializable {
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Price")
    @Expose
    private BigDecimal price;

    public PartNamePriceViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
