package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {
    private Order order;
    private Item item;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Order order, Item item, Integer quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @NotNull
    @Min(1)
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
