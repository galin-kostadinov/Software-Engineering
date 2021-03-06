package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private String email;
    private Set<Ticket> tickets;
    private Town town;

    public Passenger() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "passenger", fetch = FetchType.EAGER)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
