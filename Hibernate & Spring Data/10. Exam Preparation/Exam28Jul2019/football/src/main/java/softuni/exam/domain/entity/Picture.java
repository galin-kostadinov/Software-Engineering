package softuni.exam.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String url;

    public Picture() {
    }

    @NotNull
    @Column(name = "url", nullable = false, unique = true)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
