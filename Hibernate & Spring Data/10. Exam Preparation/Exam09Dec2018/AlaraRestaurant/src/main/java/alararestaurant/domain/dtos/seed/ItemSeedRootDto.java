package alararestaurant.domain.dtos.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemSeedRootDto implements Serializable {

    @XmlElement(name = "item")
    List<ItemSeedXmlDto> items;

    public ItemSeedRootDto() {
    }

    public List<ItemSeedXmlDto> getItems() {
        return items;
    }

    public void setItems(List<ItemSeedXmlDto> items) {
        this.items = items;
    }
}
