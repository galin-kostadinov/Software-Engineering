package softuni.exam.domain.dto.seed.json;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TeamSeedJsonDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private PictureSeedJsonDto picture;

    public TeamSeedJsonDto() {
    }

    @NotNull
    @Length(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureSeedJsonDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedJsonDto picture) {
        this.picture = picture;
    }
}
