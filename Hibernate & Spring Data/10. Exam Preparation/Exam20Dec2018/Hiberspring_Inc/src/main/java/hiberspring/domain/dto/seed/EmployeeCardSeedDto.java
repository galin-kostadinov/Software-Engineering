package hiberspring.domain.dto.seed;

import com.google.gson.annotations.Expose;
import hiberspring.domain.entities.BaseEntity;

import javax.validation.constraints.NotNull;

public class EmployeeCardSeedDto extends BaseEntity {
    @Expose
    private String number;

    public EmployeeCardSeedDto() {
    }

    @NotNull
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
