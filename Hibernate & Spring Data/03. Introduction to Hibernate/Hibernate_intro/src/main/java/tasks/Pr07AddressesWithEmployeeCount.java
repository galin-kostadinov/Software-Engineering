package tasks;

import entities.Address;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Pr07AddressesWithEmployeeCount implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr07AddressesWithEmployeeCount(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        this.entityManager.getTransaction().begin();

        entityManager.
                createQuery("FROM Address a ORDER BY size(a.employees) DESC, a.town.id", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(address -> System.out.printf("%s, %s - %d employees%n",
                        address.getText(),
                        address.getTown().getName(),
                        address.getEmployees().size()));

        this.entityManager.getTransaction().commit();
    }
}
