package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelTravelledDistanceViewRootDto {

    @XmlElement(name = "car")
    List<CarMakeModelTravelledDistanceViewDto> cars;

    public CarMakeModelTravelledDistanceViewRootDto() {
    }

    public CarMakeModelTravelledDistanceViewRootDto(List<CarMakeModelTravelledDistanceViewDto> cars) {
        this.cars = cars;
    }

    public List<CarMakeModelTravelledDistanceViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarMakeModelTravelledDistanceViewDto> cars) {
        this.cars = cars;
    }
}
