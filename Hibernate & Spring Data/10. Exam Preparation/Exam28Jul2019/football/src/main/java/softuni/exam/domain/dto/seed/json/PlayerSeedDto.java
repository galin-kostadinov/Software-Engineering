package softuni.exam.domain.dto.seed.json;

import com.google.gson.annotations.Expose;
import softuni.exam.domain.entity.Position;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class PlayerSeedDto implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer number;

    @Expose
    private BigDecimal salary;

    @Expose
    private Position position;

    @Expose
    private PictureSeedJsonDto picture;

    @Expose
    private TeamSeedJsonDto team;

    public PlayerSeedDto() {
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(min = 3, max = 15)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @NotNull
    @DecimalMin(value = "0")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @NotNull
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @NotNull
    public PictureSeedJsonDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedJsonDto picture) {
        this.picture = picture;
    }

    @NotNull
    public TeamSeedJsonDto getTeam() {
        return team;
    }

    public void setTeam(TeamSeedJsonDto team) {
        this.team = team;
    }
}
