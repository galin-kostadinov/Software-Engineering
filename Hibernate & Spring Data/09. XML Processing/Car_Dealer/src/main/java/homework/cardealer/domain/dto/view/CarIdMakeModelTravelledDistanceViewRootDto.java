package homework.cardealer.domain.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarIdMakeModelTravelledDistanceViewRootDto {

    @XmlElement(name = "car")
    List<CarIdMakeModelTravelledDistanceViewDto> cars;

    public CarIdMakeModelTravelledDistanceViewRootDto() {
    }

    public CarIdMakeModelTravelledDistanceViewRootDto(List<CarIdMakeModelTravelledDistanceViewDto> cars) {
        this.cars = cars;
    }

    public List<CarIdMakeModelTravelledDistanceViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarIdMakeModelTravelledDistanceViewDto> cars) {
        this.cars = cars;
    }
}
