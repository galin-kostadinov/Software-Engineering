package tasks;

import entities.Department;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Pr13EmployeesMaximumSalaries implements Executable {
    private final EntityManager entityManager;
    private BufferedReader br;

    public Pr13EmployeesMaximumSalaries(EntityManager entityManager, BufferedReader br) {
        this.entityManager = entityManager;
        this.br = br;
    }

    @Override
    public void execute() throws IOException {
        this.entityManager.getTransaction().begin();

        List<Object[]> resultList = this.entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS max_salary\n" +
                "FROM departments d\n" +
                "JOIN employees e ON d.department_id = e.department_id\n" +
                "GROUP BY e.department_id\n" +
                "HAVING max_salary NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        for (Object[] r : resultList) {
            System.out.printf("%s - %s%n", r[0], r[1]);
        }

        this.entityManager.getTransaction().commit();
    }
}
