package app.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity implements Serializable {
    private String name;
    private Set<Countrie> countries;

    public Continent() {
    }

    @Column(name = "name", unique = true, length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "continents")
    public Set<Countrie> getCountries() {
        return countries;
    }

    public void setCountries(Set<Countrie> countries) {
        this.countries = countries;
    }
}
