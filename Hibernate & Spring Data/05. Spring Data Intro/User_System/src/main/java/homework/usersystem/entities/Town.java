package homework.usersystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    private String name;
    private Country country;
    private Set<User> born;
    private Set<User> live;

    public Town() {
        this.born = new HashSet<>();
        this.live = new HashSet<>();
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getBorn() {
        return born;
    }

    public void setBorn(Set<User> born) {
        this.born = born;
    }

    @OneToMany(mappedBy = "currentTown")
    public Set<User> getLive() {
        return live;
    }

    public void setLive(Set<User> live) {
        this.live = live;
    }
}
