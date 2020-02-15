package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Pr04EmployeesWithSalaryOver50000 implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr04EmployeesWithSalaryOver50000(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        entityManager.getTransaction().begin();

        entityManager
                .createQuery("FROM Employee WHERE salary > 50000;", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));

        entityManager.getTransaction().commit();
    }
}
