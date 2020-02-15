package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;

public class Pr03ContainsEmployee implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr03ContainsEmployee(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }


    @Override
    public void execute() throws IOException {
        System.out.println("Enter name:");

        String name = br.readLine();

        this.entityManager.getTransaction().begin();

        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ', last_name) = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }

        this.entityManager.getTransaction().commit();
    }
}
