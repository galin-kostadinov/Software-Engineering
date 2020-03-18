package homework.cardealer.domain.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedRootDto implements Serializable {

    @XmlElement(name = "part")
    List<PartSeedDto> parts;

    public PartSeedRootDto() {
        this.parts = new ArrayList<>();
    }

    public List<PartSeedDto> getParts() {
        return parts;
    }

    public void setParts(List<PartSeedDto> parts) {
        this.parts = parts;
    }
}
