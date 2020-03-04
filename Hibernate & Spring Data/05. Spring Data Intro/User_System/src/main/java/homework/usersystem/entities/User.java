package homework.usersystem.entities;

import homework.usersystem.annotations.Email;
import homework.usersystem.annotations.Password;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private LocalDateTime registeredOn;
    private LocalDateTime lastTimeLoggedIn;
    private Integer age;
    private Boolean isDeleted;
    private Town bornTown;
    private Town currentTown;
    private Set<User> friends;
    private Set<Album> albums;

    public User() {
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

    @Size(min = 4, max = 40)
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Password(containsLowercaseLetter = true, containsUppercaseLetter = true,
            containsDigit = true, containsSpecialSymbol = true)
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "registered_on")
    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @ManyToOne
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    public Town getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(Town currentTown) {
        this.currentTown = currentTown;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @Transient
    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    @OneToMany(mappedBy = "ownerUser")
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
