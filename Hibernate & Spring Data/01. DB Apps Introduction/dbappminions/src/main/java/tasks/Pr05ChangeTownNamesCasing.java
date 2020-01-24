package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pr05ChangeTownNamesCasing implements Executable {
    Scanner sc = new Scanner(System.in);

    Connection connection;

    public Pr05ChangeTownNamesCasing(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() throws SQLException {
        System.out.printf("Paste the task's input on the next rows:%n");

        String country = sc.nextLine();

        long count = setUppercaseTownsNames(country);

        if (count > 0) {
            printAffectedTowns(country, count);
        } else {
            System.out.println("No town names were affected.");
        }
    }

    private void printAffectedTowns(String country, long count) throws SQLException {
        String query = "SELECT name FROM towns WHERE country = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, country);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.printf("%d town names were affected.%n", count);

        resultSet.next();
        System.out.printf("[%s", resultSet.getString(1));

        for (int i = 1; i < count - 1; i++) {
            resultSet.next();
            System.out.print(", ");
            System.out.printf("%s", resultSet.getString(1));
        }

        resultSet.next();
        System.out.printf(", %s]", resultSet.getString(1));
    }

    private long setUppercaseTownsNames(String country) throws SQLException {
        String query = "UPDATE towns SET  name = UPPER(name) WHERE country = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, country);

        return preparedStatement.executeUpdate();
    }
}
