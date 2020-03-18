package homework.cardealer.domain.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRootDto implements Serializable {

    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> supplierDto;

    public SupplierSeedRootDto() {
        this.supplierDto = new ArrayList<>();
    }

    public List<SupplierSeedDto> getSupplierDto() {
        return supplierDto;
    }

    public void setSupplierDto(List<SupplierSeedDto> supplierDto) {
        this.supplierDto = supplierDto;
    }
}
