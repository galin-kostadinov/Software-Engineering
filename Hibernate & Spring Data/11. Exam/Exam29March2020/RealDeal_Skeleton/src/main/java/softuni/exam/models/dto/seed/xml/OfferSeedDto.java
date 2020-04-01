package softuni.exam.models.dto.seed.xml;

import org.hibernate.validator.constraints.Length;
import softuni.exam.config.LocalDateTimeAdaptor;

import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto implements Serializable {
    @XmlElement
    private String description;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "added-on")
    @XmlJavaTypeAdapter(LocalDateTimeAdaptor.class)
    private LocalDateTime addedOn;

    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;

    @XmlElement
    private CarIdSeedDto car;

    @XmlElement
    private SellerIdSeedDto seller;


    public OfferSeedDto() {
    }

    @Length(min = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public CarIdSeedDto getCar() {
        return car;
    }

    public void setCar(CarIdSeedDto car) {
        this.car = car;
    }

    public SellerIdSeedDto getSeller() {
        return seller;
    }

    public void setSeller(SellerIdSeedDto seller) {
        this.seller = seller;
    }
}
