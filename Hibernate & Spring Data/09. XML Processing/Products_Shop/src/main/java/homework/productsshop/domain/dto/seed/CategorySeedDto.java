package homework.productsshop.domain.dto.seed;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedDto implements Serializable {

    @XmlElement
    private String name;

    public CategorySeedDto() {
    }

    @Size(min = 3, max = 15, message = "Name must be between 3 and 15 symbols.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
