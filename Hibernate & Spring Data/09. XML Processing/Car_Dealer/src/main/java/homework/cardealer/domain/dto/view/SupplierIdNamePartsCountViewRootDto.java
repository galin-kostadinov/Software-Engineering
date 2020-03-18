package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "supliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierIdNamePartsCountViewRootDto {

    @XmlElement(name = "supplier")
    List<SupplierIdNamePartsCountViewDto> supliers;

    public SupplierIdNamePartsCountViewRootDto() {
    }

    public SupplierIdNamePartsCountViewRootDto(List<SupplierIdNamePartsCountViewDto> supliers) {
        this.supliers = supliers;
    }

    public List<SupplierIdNamePartsCountViewDto> getSupliers() {
        return supliers;
    }

    public void setSupliers(List<SupplierIdNamePartsCountViewDto> supliers) {
        this.supliers = supliers;
    }
}
