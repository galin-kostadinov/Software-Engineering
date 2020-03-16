package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class CarWithPartsViewDto implements Serializable {
    @Expose
    private CarMakeModelTravelledDistanceViewDto car;

    @Expose
    private List<PartNamePriceViewDto> parts;

    public CarWithPartsViewDto() {
    }

    public CarMakeModelTravelledDistanceViewDto getCar() {
        return car;
    }

    public void setCar(CarMakeModelTravelledDistanceViewDto car) {
        this.car = car;
    }

    public List<PartNamePriceViewDto> getParts() {
        return parts;
    }

    public void setParts(List<PartNamePriceViewDto> parts) {
        this.parts = parts;
    }
}
