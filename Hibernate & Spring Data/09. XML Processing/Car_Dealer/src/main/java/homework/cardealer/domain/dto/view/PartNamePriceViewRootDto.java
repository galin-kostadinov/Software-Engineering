package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartNamePriceViewRootDto {

    @XmlElement(name = "part")
    List<PartNamePriceViewDto> parts;

    public PartNamePriceViewRootDto(List<PartNamePriceViewDto> parts) {
        this.parts = parts;
    }

    public PartNamePriceViewRootDto() {
    }

    public List<PartNamePriceViewDto> getParts() {
        return parts;
    }

    public void setParts(List<PartNamePriceViewDto> parts) {
        this.parts = parts;
    }
}
