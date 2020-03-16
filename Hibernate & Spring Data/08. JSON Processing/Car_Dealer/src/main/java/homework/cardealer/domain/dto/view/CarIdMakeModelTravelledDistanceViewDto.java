package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CarIdMakeModelTravelledDistanceViewDto implements Serializable {
    @SerializedName("Id")
    @Expose
    private Long id;

    @SerializedName("Make")
    @Expose
    private String make;

    @SerializedName("Model")
    @Expose
    private String model;

    @SerializedName("TravelledDistance")
    @Expose
    private Long travelledDistance;

    public CarIdMakeModelTravelledDistanceViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
