package homework.usersystem.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private String title;
    private String caption;
    private String path;
    private Set<Album> albums;

    public Picture() {
    }

    @Column(name = "title", nullable = false, updatable = false, insertable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "title")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Column(name = "path", nullable = false)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @ManyToMany
    @JoinTable(name = "pictures_albums",
            joinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id")
    )
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
