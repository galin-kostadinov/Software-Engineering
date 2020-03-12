package homework.productsshop.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private Set<Product> products;

    public Category() {
        this.products = new HashSet<>();
    }

    @Size(min = 3, max = 15)
    @Column(name = "name", nullable = false, unique = true, length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Product.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(name = "category_products",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    public Set<Product> getProducts() {
        return products;
    }
   // cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
