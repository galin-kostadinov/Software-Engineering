package homework.cardealer.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String make;
    private String model;
    private Long travelledDistance;
    private Set<Part> parts;
    private Sale sale;

    public Car() {
    }

    @NotNull(message = "Car Make cannot be null.")
    @Column(name = "make", nullable = false, updatable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @NotNull(message = "Car Model cannot be null.")
    @Column(name = "model", nullable = false,  updatable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull(message = "Car travelled distance cannot be null.")
    @Min(value = 0, message = "Travelled distance cannot be negative.")
    @Column(name = "travelled_distance", nullable = false)
    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(targetEntity = Part.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cars_parts",
    joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
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
