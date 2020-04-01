package hiberspring.domain.dto.seed.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeSeedRootDto implements Serializable {
    @XmlElement(name = "employee")
    List<EmployeeSeedDto> employees;

    public EmployeeSeedRootDto() {
    }

    public List<EmployeeSeedDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeSeedDto> employees) {
        this.employees = employees;
    }
}
