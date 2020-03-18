package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithCarCustomerDiscountPriceViewRootDto {

    @XmlElement(name = "sale")
    List<SaleWithCarCustomerDiscountPriceViewDto> sale;

    public SaleWithCarCustomerDiscountPriceViewRootDto(List<SaleWithCarCustomerDiscountPriceViewDto> sale) {
        this.sale = sale;
    }

    public SaleWithCarCustomerDiscountPriceViewRootDto() {
    }

    public List<SaleWithCarCustomerDiscountPriceViewDto> getSale() {
        return sale;
    }

    public void setSale(List<SaleWithCarCustomerDiscountPriceViewDto> sale) {
        this.sale = sale;
    }
}
