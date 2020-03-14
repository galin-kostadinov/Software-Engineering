package homework.productsshop.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SoldProductsCountNamePriceDto implements Serializable {
    @Expose
    private Long count;
    @Expose
    private Set<ProductNamePriceDto> products;

    public SoldProductsCountNamePriceDto() {
        this.products = new HashSet<>();
    }

    public SoldProductsCountNamePriceDto(Long count, Set<ProductNamePriceDto> products) {
        this.count = count;
        this.products = products;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<ProductNamePriceDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductNamePriceDto> products) {
        this.products = products;
    }
}
