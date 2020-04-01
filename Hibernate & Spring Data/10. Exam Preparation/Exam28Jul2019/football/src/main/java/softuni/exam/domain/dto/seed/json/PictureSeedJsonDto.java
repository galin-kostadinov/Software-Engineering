package softuni.exam.domain.dto.seed.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PictureSeedJsonDto implements Serializable {

    @Expose
    private String url;

    public PictureSeedJsonDto() {
    }

    @NotNull
    @Size(min = 3, max = 15)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
