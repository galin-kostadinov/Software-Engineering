package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pr09IncreaseAgeStoredProcedure implements Executable {
    Scanner sc = new Scanner(System.in);

    Connection connection;

    public Pr09IncreaseAgeStoredProcedure(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() throws SQLException {
        System.out.printf("Enter minion id:%n");

        int id = Integer.parseInt(sc.nextLine());

        makeOlder(id);
        ResultSet resultSet = getMinionById(id);
        printMinion(resultSet);
    }

    private ResultSet getMinionById(int id) throws SQLException {
        String query = "SELECT name, age FROM minions WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    private void printMinion(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString(1),
                    resultSet.getLong(2));
        }
    }

    private void makeOlder(int id) throws SQLException {
        String query = "CALL usp_get_older(?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
