package softuni.exam.domain.dto.seed.xml;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class  PicturesSeedDto implements Serializable {

    @Expose
    @XmlElement(name = "url")
    private String url;

    public PicturesSeedDto() {
    }

    @NotNull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
