package alararestaurant.domain.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    Long id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}