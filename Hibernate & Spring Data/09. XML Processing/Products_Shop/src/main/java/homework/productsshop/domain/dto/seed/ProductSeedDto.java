package homework.productsshop.domain.dto.seed;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto implements Serializable {

    @XmlElement
    private String name;

    @XmlElement
    private BigDecimal price;

    public ProductSeedDto() {
    }

    @NotNull(message = "Name cannot be null.")
    @Length(min = 3, message = "Name should be at least 3 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Price cannot be null.")
    @DecimalMin(value = "0", message = "Price cannot be negative.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
