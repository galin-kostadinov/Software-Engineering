package softuni.exam.models.dto.seed.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellersSeedRootDto implements Serializable {
    @XmlElement(name = "seller")
    List<SellerSeedDto> sellers;

    public SellersSeedRootDto(List<SellerSeedDto> sellers) {
        this.sellers = sellers;
    }

    public SellersSeedRootDto() {
    }

    public List<SellerSeedDto> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerSeedDto> sellers) {
        this.sellers = sellers;
    }
}
