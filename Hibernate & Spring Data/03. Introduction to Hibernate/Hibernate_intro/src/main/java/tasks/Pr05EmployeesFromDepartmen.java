package tasks;

import entities.Department;
import entities.Employee;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;

public class Pr05EmployeesFromDepartmen implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr05EmployeesFromDepartmen(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = 'Research and Development'\n" +
                "ORDER BY e.salary, e.id", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s from %s - $%.2f%n",
                        employee.getFirstName(), employee.getLastName(),
                        employee.getDepartment().getName(),
                        employee.getSalary()));

        entityManager.getTransaction().commit();
    }
}
