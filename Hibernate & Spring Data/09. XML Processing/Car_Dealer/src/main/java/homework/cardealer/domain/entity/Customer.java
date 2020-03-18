package homework.cardealer.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    private String name;
    private LocalDateTime birthDate;
    private boolean isYoungDriver;
    private Set<Sale> purchases;

    public Customer() {
    }

    @NotNull(message = "Customer name cannot be null.")
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Customer birth date cannot be null.")
    @Column(name = "birth_date", nullable = false)
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull(message = "Customer is_young_driver cannot be null.")
    @Column(name = "is_young_driver", nullable = false)
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Sale> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Sale> purchases) {
        this.purchases = purchases;
    }
}
