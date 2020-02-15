package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Pr12FindEmployeesByFirstName implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr12FindEmployeesByFirstName(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Enter pattern for the firth name of the employees:");
        String pattern = br.readLine();

        this.entityManager.getTransaction().begin();

        this.entityManager
                .createQuery("FROM Employee e WHERE e.firstName LIKE(concat(:pattern,'','%') )", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));

        this.entityManager.getTransaction().commit();
    }
}
