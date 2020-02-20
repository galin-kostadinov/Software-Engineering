package app.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation {
    private long id;
    private LocalDate date;
    private  String comment;
    private Patient patient;

    public Visitation() {
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

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "comment", length = 2000, nullable = false)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "pation_id", referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
