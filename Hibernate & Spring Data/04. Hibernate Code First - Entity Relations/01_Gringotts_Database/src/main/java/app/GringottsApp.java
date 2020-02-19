package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GringottsApp {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gringotts_db");

        EntityManager manager = factory.createEntityManager();
    }
}
