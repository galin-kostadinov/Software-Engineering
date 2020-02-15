import tasks.*;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        System.out.printf("-------------------------------------------------%n");
        System.out.printf("Please, Enter number of the task on first row:%n");
        System.out.printf("Enter 2 to 'Remove Objects'%n");
        System.out.printf("Enter 3 to 'Contains Employee'%n");
        System.out.printf("Enter 4 to 'Employees with Salary Over 50 000'%n");
        System.out.printf("Enter 5 to 'Employees from Department'%n");
        System.out.printf("Enter 6 to 'Adding a New Address and Updating Employee'%n");
        System.out.printf("Enter 7 to 'Addresses with Employee Count'%n");
        System.out.printf("Enter 8 to 'Get Employee with Project'%n");
        System.out.printf("Enter 9 to 'Find Latest 10 Projects'%n");
        System.out.printf("Enter 10 to 'Increase Salaries'%n");
        System.out.printf("Enter 11 to 'Remove Towns'%n");
        System.out.printf("Enter 12 to 'Find Employees by First Name'%n");
        System.out.printf("Enter 13 to 'Employees Maximum Salaries'%n");
        System.out.printf("-------------------------------------------------%n");

        Executable task = null;

        try {
            task = parseInput(Integer.parseInt(br.readLine()));
            task.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Executable parseInput(int taskNumber) {
        Executable task = null;

        switch (taskNumber) {
            case 2:
                task = new Pr02RemoveObjects(entityManager, br);
                break;
            case 3:
                task = new Pr03ContainsEmployee(entityManager, br);
                break;
            case 4:
                task = new Pr04EmployeesWithSalaryOver50000(entityManager, br);
                break;
            case 5:
                task = new Pr05EmployeesFromDepartmen(entityManager, br);
                break;
            case 6:
                task = new Pr06AddingNewAddressAndUpdatingEmployee(entityManager, br);
                break;
            case 7:
                task = new Pr07AddressesWithEmployeeCount(entityManager, br);
                break;
            case 8:
                task = new Pr08GetEmployeeWithProject(entityManager, br);
                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
            case 13:

                break;
            default:
                System.out.println("Incorrect input.");
                break;
        }

        return task;
    }
}
