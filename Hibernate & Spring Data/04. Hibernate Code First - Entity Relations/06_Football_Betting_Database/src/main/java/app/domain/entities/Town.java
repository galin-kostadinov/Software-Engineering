package app.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "towns")
public class Town extends BaseEntity implements Serializable {
    private String name;
    private Countrie countrie;
    private Set<Team> teams;

    public Town() {
    }

    @Column(name = "name", unique = true, length = 15, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "countrie_id", referencedColumnName = "id")
    public Countrie getCountrie() {
        return countrie;
    }

    public void setCountrie(Countrie countrie) {
        this.countrie = countrie;
    }

    @OneToMany(mappedBy = "town")
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
