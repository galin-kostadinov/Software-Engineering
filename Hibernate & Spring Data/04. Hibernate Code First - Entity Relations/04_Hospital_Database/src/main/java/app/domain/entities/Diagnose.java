package app.domain.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose {
    private long id;
    private String name;
    private String comment;
    private Set<Patient> patients;

    public Diagnose() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT NOT NULL")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name",length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comment", length = 2000)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToMany(mappedBy = "diagnoses")
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
