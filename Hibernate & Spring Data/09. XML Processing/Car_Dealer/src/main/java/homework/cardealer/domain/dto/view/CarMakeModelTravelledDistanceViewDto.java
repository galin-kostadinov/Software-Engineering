package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelTravelledDistanceViewDto implements Serializable {

    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @XmlElement(name = "parts")
    private PartNamePriceViewRootDto parts;

    public CarMakeModelTravelledDistanceViewDto() {

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartNamePriceViewRootDto getParts() {
        return parts;
    }

    public void setParts(PartNamePriceViewRootDto parts) {
        this.parts = parts;
    }
}
