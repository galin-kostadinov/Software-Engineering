package homework.cardealer.domain.entity;

import jdk.jfr.Unsigned;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String make;
    private String model;
    private Long travelledDistance;
    private List<Part> parts;
    private Sale sale;

    public Car() {
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(targetEntity = Part.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @OneToOne(mappedBy = "car", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
