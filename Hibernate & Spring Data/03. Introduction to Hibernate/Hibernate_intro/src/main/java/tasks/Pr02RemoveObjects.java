package tasks;

import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Pr02RemoveObjects implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr02RemoveObjects(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        try {
            //Persist all towns from the database.
            List<Town> towns = entityManager
                    .createQuery("SELECT t FROM Town t", Town.class)
                    .getResultList();

            //Detach those whose name length is more than 5 symbols.
            for (Town town : towns) {
                if (town.getName().length() > 5) {
                    this.entityManager.detach(town);
                }
            }

            this.entityManager.getTransaction().begin();

            for (Town town : towns) {
                //transform the names of all attached towns to lowercase and save them to the database
                if (entityManager.contains(town)) {
                    System.out.print(town.getName() + " -> ");

                    this.entityManager.detach(town);
                    town.setName(town.getName().toLowerCase());
                    this.entityManager.merge(town);

                    System.out.println(town.getName());
                }
            }

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }
}
