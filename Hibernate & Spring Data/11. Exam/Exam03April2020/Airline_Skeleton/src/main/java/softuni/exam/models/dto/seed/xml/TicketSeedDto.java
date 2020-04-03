package softuni.exam.models.dto.seed.xml;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedDto implements Serializable {

    @XmlElement(name = "serial-number")
    private String serialNumber;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeoff;

    @XmlElement(name = "from-town")
    private TownFromTownDto fromTown;

    @XmlElement(name = "to-town")
    private TownToTownDto toTown;

    @XmlElement
    private PassengerSeedXmlDto passenger;

    @XmlElement
    private PlaneSeedXmlDto plane;

    public TicketSeedDto() {
    }

    @NotNull
    @Length(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @DecimalMin(value = "0")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public TownFromTownDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownFromTownDto fromTown) {
        this.fromTown = fromTown;
    }

    public TownToTownDto getToTown() {
        return toTown;
    }

    public void setToTown(TownToTownDto toTown) {
        this.toTown = toTown;
    }

    public PassengerSeedXmlDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerSeedXmlDto passenger) {
        this.passenger = passenger;
    }

    public PlaneSeedXmlDto getPlane() {
        return plane;
    }

    public void setPlane(PlaneSeedXmlDto plane) {
        this.plane = plane;
    }
}
