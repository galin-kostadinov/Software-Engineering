package softuni.exam.models.dto.seed.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketRootSeedDto implements Serializable {
    @XmlElement(name = "ticket")
    List<TicketSeedDto> tickets;

    public TicketRootSeedDto() {
    }

    public TicketRootSeedDto(List<TicketSeedDto> tickets) {
        this.tickets = tickets;
    }

    public List<TicketSeedDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketSeedDto> tickets) {
        this.tickets = tickets;
    }
}
