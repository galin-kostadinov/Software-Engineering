package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsCountNamePriceViewDto implements Serializable {

    @XmlAttribute
    private Long count;

    @XmlElement(name = "product")
    private Set<ProductNamePriceViewDto> products;

    public SoldProductsCountNamePriceViewDto() {
        this.products = new HashSet<>();
    }

    public SoldProductsCountNamePriceViewDto(Long count, Set<ProductNamePriceViewDto> products) {
        this.count = count;
        this.products = products;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<ProductNamePriceViewDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductNamePriceViewDto> products) {
        this.products = products;
    }
}
