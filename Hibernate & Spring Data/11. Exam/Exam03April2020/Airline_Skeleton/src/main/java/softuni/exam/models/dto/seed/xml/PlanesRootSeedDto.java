package softuni.exam.models.dto.seed.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanesRootSeedDto implements Serializable {

    @XmlElement(name = "plane")
    List<PlaneSeedDto> planes;

    public PlanesRootSeedDto() {
    }

    public List<PlaneSeedDto> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneSeedDto> planes) {
        this.planes = planes;
    }
}
