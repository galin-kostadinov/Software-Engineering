package tasks;

import entities.Address;
import entities.Employee;
import entities.Town;
import tasks.Executable;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Pr11RemoveTowns implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr11RemoveTowns(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Enter town name:");
        String townName = br.readLine();

        try {


            this.entityManager.getTransaction().begin();

            List<Address> addresses = this.entityManager
                    .createQuery("FROM Address a WHERE a.town.name = :town_name", Address.class)
                    .setParameter("town_name", townName)
                    .getResultList();

            int count = addresses.size();


            addresses.forEach(address -> {
                for (Employee employee : address.getEmployees()) {
                    employee.setAddress(null);
                }
                address.setTown(null);
                entityManager.remove(address);
            });

            Town town = this.entityManager
                    .createQuery("FROM Town t WHERE t.name = :town_name", Town.class)
                    .setParameter("town_name", townName)
                    .getSingleResult();

            entityManager.remove(town);

            System.out.printf("%d %s in %s deleted", count, count == 1 ? "address" : "addresses", townName);

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
