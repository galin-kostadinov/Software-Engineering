package alararestaurant.domain.dtos.seed;

import alararestaurant.adaptor.LocalDateTimeAdaptor;
import alararestaurant.domain.entities.OrderType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderSeedDto {

    @XmlElement(name = "customer")
    private String customer;

    @XmlElement(name = "employee")
    private String employee;

    @XmlElement(name = "date-time")
    @XmlJavaTypeAdapter(LocalDateTimeAdaptor.class)
    private LocalDateTime dateTime;

    @XmlElement(name = "type")
    private OrderType type;

    @XmlElement(name = "items")
    private ItemSeedRootDto items;

    public OrderSeedDto() {
    }

    @NotNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @NotNull
    @Length(min = 3, max = 30)
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @NotNull
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public ItemSeedRootDto getItems() {
        return items;
    }

    public void setItems(ItemSeedRootDto items) {
        this.items = items;
    }
}
