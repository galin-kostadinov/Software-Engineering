package homework.bookshopsystem.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = ("INT NOT NULL"))
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
