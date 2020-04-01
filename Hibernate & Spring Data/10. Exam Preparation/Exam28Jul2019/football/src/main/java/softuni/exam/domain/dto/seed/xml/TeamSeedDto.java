package softuni.exam.domain.dto.seed.xml;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedDto implements Serializable {

    @Expose
    @XmlElement(name = "name")
    private String name;

    @Expose
    @XmlElement(name = "picture")
    private PicturesSeedDto picture;

    public TeamSeedDto() {
    }

    @NotNull
    @Length(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PicturesSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PicturesSeedDto picture) {
        this.picture = picture;
    }
}
