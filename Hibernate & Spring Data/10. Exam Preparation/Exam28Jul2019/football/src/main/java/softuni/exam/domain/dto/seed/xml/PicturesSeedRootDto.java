package softuni.exam.domain.dto.seed.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PicturesSeedRootDto implements Serializable {

    @XmlElement(name = "picture")
    List<PicturesSeedDto> pictures;

    public PicturesSeedRootDto() {
    }

    public List<PicturesSeedDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PicturesSeedDto> pictures) {
        this.pictures = pictures;
    }
}
