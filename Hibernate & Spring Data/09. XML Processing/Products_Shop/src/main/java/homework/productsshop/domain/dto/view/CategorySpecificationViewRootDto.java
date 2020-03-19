package homework.productsshop.domain.dto.view;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySpecificationViewRootDto {
    @XmlElement(name = "category")
    List<CategorySpecificationViewDto> categories;

    public CategorySpecificationViewRootDto(List<CategorySpecificationViewDto> categories) {
        this.categories = categories;
    }

    public CategorySpecificationViewRootDto() {
    }

    public List<CategorySpecificationViewDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySpecificationViewDto> categories) {
        this.categories = categories;
    }
}
