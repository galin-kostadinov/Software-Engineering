package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerNameBoughtCarsSpendMoneyViewRootDto implements Serializable {

    @XmlElement(name = "customer")
    List<CustomerNameBoughtCarsSpendMoneyViewDto> customers;

    public CustomerNameBoughtCarsSpendMoneyViewRootDto(List<CustomerNameBoughtCarsSpendMoneyViewDto> customers) {
        this.customers = customers;
    }

    public CustomerNameBoughtCarsSpendMoneyViewRootDto() {
    }

    public List<CustomerNameBoughtCarsSpendMoneyViewDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerNameBoughtCarsSpendMoneyViewDto> customers) {
        this.customers = customers;
    }
}
