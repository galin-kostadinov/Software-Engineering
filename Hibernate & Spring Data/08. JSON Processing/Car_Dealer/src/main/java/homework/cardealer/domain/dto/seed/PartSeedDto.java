package homework.cardealer.domain.dto.seed;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class PartSeedDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private Integer quantity;

    public PartSeedDto() {
    }

    @NotNull(message = "Part name cannot be null.")
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Part price cannot be null.")
    @DecimalMin(value = "0", message = "Part price cannot be negative.")
    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "Part quantity cannot be null.")
    @Min(value = 0, message = "Part quantity cannot be negative.")
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
