package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleWithCarCustomerDiscountPrice implements Serializable {
    @Expose
    private CarMakeModelTravelledDistanceViewDto car;

    @Expose
    private String customerName;

    @SerializedName("Discount")
    @Expose
    private Double discount;

    @Expose
    private BigDecimal price;

    @Expose
    private BigDecimal priceWithDiscount;

    public SaleWithCarCustomerDiscountPrice() {
    }

    public CarMakeModelTravelledDistanceViewDto getCar() {
        return car;
    }

    public void setCar(CarMakeModelTravelledDistanceViewDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
