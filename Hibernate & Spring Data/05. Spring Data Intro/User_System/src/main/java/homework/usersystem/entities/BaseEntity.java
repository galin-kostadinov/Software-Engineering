package homework.usersystem.entities;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    Long id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT NOT NULL")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
