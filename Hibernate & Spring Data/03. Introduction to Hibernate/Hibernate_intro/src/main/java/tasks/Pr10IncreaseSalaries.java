package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Pr10IncreaseSalaries implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr10IncreaseSalaries(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        this.entityManager.getTransaction().begin();

        List<Employee> resultList = this.entityManager
                .createQuery("FROM Employee e " +
                        "WHERE e.department.name " +
                        "IN('Engineering','Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList();

        resultList.forEach(employee -> {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            System.out.printf("%s %s ($%.2f)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary());
        });

        this.entityManager.getTransaction().commit();
    }
}
