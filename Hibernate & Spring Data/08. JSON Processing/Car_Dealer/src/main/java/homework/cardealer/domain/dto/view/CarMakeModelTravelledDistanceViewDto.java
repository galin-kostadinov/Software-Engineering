package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CarMakeModelTravelledDistanceViewDto implements Serializable {
    @SerializedName("Make")
    @Expose
    private String make;

    @SerializedName("Model")
    @Expose
    private String model;

    @SerializedName("TravelledDistance")
    @Expose
    private Long travelledDistance;

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
}
