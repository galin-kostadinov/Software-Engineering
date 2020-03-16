package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import homework.cardealer.domain.entity.Sale;

import java.io.Serializable;
import java.util.Date;

public class CustomerIdNameBDIsYoungerDriverViewDto implements Serializable {
    @SerializedName("Id")
    @Expose
    private long id;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("BirthDate")
    @Expose
    private Date birthDate;

    @SerializedName("IsYoungDriver")
    @Expose
    private boolean isYoungDriver;

    @SerializedName("Sales")
    @Expose()
    private Sale[] purchases;

    public CustomerIdNameBDIsYoungerDriverViewDto() {
        this.purchases = new Sale[0];
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Sale[] getPurchases() {
        return purchases;
    }

    public void setPurchases(Sale[] sales) {
        this.purchases = sales;
    }
}
