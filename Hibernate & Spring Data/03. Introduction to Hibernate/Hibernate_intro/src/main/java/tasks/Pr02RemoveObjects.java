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
        try{
            this.entityManager.getTransaction().begin();

            List<Town> towns = this.entityManager
                    .createQuery("FROM Town WHERE char_length(name) > 5", Town.class)
                    .getResultList();


            for (Town town : towns) {
                entityManager.detach(town);
                town.setName(town.getName().toLowerCase());
                entityManager.merge(town);
            }

            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
