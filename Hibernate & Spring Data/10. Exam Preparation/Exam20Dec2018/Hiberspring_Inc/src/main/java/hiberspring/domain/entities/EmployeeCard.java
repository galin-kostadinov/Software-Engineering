package hiberspring.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees_card")
public class EmployeeCard extends BaseEntity {
    private String number;
    private Employee employee;

    public EmployeeCard() {
    }

    @Column(name = "number", nullable = false, unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne(mappedBy = "card", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}