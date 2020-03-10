package homework.gamestore.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    private String title;
    private String trailer;
    private String imageThumbnail;
    private double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;
   // private Set<User> users;

    public Game() {

    }

    @Column(name = "title", nullable = false)
    @Pattern(regexp = "[A-Z][A-Za-z0-9]{2,99}", message = "Title is incorrect")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "trailer", unique = true, length = 11)
    @Size(min = 11, max = 11)
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column(name = "image_thumbnail", unique = true)
    @Pattern(regexp = "^(http|https):\\/\\/.+$", message = "Invalid protocol.")
    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    @Column(name = "size", nullable = false, precision = 19, scale = 1)
    @Min(value = 0)
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Column(name = "price", nullable = false, precision = 19, scale = 2)
    @Min(value = 0)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "description", length = 1000)
    @Size(min = 20, max = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "release_date", nullable = false)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

//    @ManyToMany(targetEntity = User.class, mappedBy = "games",
//            fetch = FetchType.EAGER,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    @Override
    public int hashCode() {
        return getTitle().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Game))
            return false;
        return getTitle().equals(((Game) obj).getTitle());
    }
}
