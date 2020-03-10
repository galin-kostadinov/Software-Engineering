package homework.gamestore.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private Set<Game> games;
    private Set<Game> shoppingCard;

    public User() {
        this.games = new HashSet<>();
        this.shoppingCard = new HashSet<>();
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "email", unique = true, nullable = false)
    @Pattern(regexp = "^[A-Za-z1-9-_]+@[a-z]+\\.[a-z]{2,4}$", message = "Incorrect email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s)[0-9a-zA-Z!@#$%^&*()]*$", message = "Incorrect password.")
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    @JoinTable(name = "user_game",
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @ManyToMany
    @JoinTable(name = "user_shoping_cart_game",
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    public Set<Game> getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(Set<Game> shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    @Override
    public int hashCode() {
        return getEmail().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof User))
            return false;
        return getEmail().equals(((User) obj).getEmail());
    }
}
