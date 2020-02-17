package tasks;

import entities.Project;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Pr09FindLatest10Projects implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr09FindLatest10Projects(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        entityManager.getTransaction().begin();

        List<Project> projects = this.entityManager
                .createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s%n", p.getName());
                    System.out.printf("\tProject Description: %s%n", p.getDescription());
                    System.out.printf("\tProject Start Date:%s%n", p.getStartDate());
                    System.out.printf("\tProject End Date: %s%n", p.getEndDate());
                });

        entityManager.getTransaction().commit();
    }
}
