package softuni.exam.models.dto.seed.json;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PictureSeedDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private String dateAndTime;
    @Expose
    private Long car;

    public PictureSeedDto(String name, String dateAndTime, Long car) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.car = car;
    }

    @NotNull
    @Length(min = 2, max = 19)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}
