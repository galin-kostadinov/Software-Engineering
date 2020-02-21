package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BillsPaymentSystemApp {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bills_db");

        EntityManager manager = factory.createEntityManager();
    }
}
