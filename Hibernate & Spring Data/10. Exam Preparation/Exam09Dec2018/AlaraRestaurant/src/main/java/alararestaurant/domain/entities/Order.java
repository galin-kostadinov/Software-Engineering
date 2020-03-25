package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private String customer;
    private LocalDateTime dateTime;
    private OrderType type;
    private Employee employee;
    private List<OrderItem> orderItems;

    public Order() {
    }

    @NotNull
    @Column(name = "customer", length = 65535, columnDefinition = "text", nullable = false)
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @NotNull
    @Column(name = "date_time", nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('ForHere', 'ToGo') default 'ForHere'", nullable = false)
    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
