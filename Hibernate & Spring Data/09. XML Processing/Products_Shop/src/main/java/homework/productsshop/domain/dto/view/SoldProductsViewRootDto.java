package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsViewRootDto implements Serializable {

    @XmlElement(name = "product")
    List<SoldProductsViewDto> products;

    public SoldProductsViewRootDto() {
        this.products = new ArrayList<>();
    }

    public SoldProductsViewRootDto(List<SoldProductsViewDto> products) {
        this.products = products;
    }

    public List<SoldProductsViewDto> getProducts() {
        return products;
    }

    public void setProducts(List<SoldProductsViewDto> products) {
        this.products = products;
    }
}
