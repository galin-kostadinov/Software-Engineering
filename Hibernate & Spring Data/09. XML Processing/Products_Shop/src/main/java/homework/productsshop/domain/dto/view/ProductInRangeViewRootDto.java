package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeViewRootDto implements Serializable {

    @XmlElement(name = "product")
    List<ProductInRangeViewDto> products;

    public ProductInRangeViewRootDto() {
    }

    public ProductInRangeViewRootDto(List<ProductInRangeViewDto> products) {
        this.products = products;
    }

    public List<ProductInRangeViewDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeViewDto> products) {
        this.products = products;
    }
}
