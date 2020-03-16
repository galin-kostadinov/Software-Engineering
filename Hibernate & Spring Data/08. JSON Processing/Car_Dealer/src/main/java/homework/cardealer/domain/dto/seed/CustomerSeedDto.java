package homework.cardealer.domain.dto.seed;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class CustomerSeedDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private Date birthDate;
    @Expose
    private boolean isYoungDriver;

    public CustomerSeedDto() {
    }

    @NotNull(message = "Customer name cannot be null.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Birth date cannot be null.")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @NotNull(message = "is_young_driver cannot be null.")
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
