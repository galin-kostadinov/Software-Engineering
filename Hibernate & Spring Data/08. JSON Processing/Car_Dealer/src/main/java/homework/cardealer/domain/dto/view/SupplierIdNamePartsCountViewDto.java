package homework.cardealer.domain.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SupplierIdNamePartsCountViewDto implements Serializable {
    @SerializedName("Id")
    @Expose
    private Long id;

    @SerializedName("Name")
    @Expose
    private String name;

    @Expose
    private Integer partsCount;

    public SupplierIdNamePartsCountViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}
