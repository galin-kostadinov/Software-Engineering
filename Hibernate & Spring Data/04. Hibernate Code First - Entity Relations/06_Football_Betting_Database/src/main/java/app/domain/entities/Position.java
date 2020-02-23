package app.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position  implements Serializable {
    private String id;
    private String positionDescription;
    private Set<Player> players;

    public Position() {
    }

    @Id
    @Column(name = "id", length = 2, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "position_description", length = 30, nullable = false)
    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    @OneToMany(mappedBy = "position")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
