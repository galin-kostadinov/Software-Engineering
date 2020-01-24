package app;

import tasks.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Engine implements Runnable {
    Scanner sc = new Scanner(System.in);

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        System.out.printf("-------------------------------------------------%n");
        System.out.printf("Please, Enter number of the task on first row:%n");
        System.out.printf("Press 2 to 'Get Villains’ Names'%n");
        System.out.printf("Press 3 to 'Get Minion Names'%n");
        System.out.printf("Press 4 to 'Add Minion'%n");
        System.out.printf("Press 5 to 'Change Town Names Casing'%n");
        System.out.printf("Press 6 to 'Remove Villain'%n");
        System.out.printf("Press 7 to 'Print All Minion Names'%n");
        System.out.printf("Press 8 to 'Increase Minions Age'%n");
        System.out.printf("Press 9 to 'Increase Age Stored Procedure'%n");
        System.out.printf("-------------------------------------------------%n");

        Executable task = null;

        try {
            task = parseInput(Integer.parseInt(sc.nextLine()));
            task.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Executable parseInput(int taskNumber) {
        Executable task = null;

        switch (taskNumber) {
            case 2:
                task = new Pr02GetVillainsNames(connection);
                break;
            case 3:
                task = new Pr03GetMinionNames(connection);
                break;
            case 4:
                task = new Pr04AddMinion(connection);
                break;
            case 5:
                task = new Pr05ChangeTownNamesCasing(connection);
                break;
            case 6:
                task = new Pr06RemoveVillain(connection);
                break;
            case 7:
                task = new Pr07PrintAllMinionNames(connection);
                break;
            case 8:
                task = new Pr08IncreaseMinionsAge(connection);
                break;
            case 9:
                task = new Pr09IncreaseAgeStoredProcedure(connection);
                break;
            default:
                System.out.println("Incorrect input.");
                break;
        }

        return task;
    }
}
