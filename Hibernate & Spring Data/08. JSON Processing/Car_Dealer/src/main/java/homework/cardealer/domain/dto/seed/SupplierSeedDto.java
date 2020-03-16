package homework.cardealer.domain.dto.seed;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SupplierSeedDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    @NotNull(message = "Supplier name cannot be null.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Supplier is_importer cannot be null.")
    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
