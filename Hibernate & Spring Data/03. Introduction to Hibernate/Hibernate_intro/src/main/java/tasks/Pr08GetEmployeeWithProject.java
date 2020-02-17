package tasks;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Pr08GetEmployeeWithProject implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr08GetEmployeeWithProject(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Enter employee id:");

        int id = Integer.parseInt(br.readLine());

        entityManager.getTransaction().begin();

        Employee employee = entityManager
                .createQuery("FROM Employee WHERE id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();


        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println("   " + p.getName()));

        entityManager.getTransaction().commit();
    }
}
