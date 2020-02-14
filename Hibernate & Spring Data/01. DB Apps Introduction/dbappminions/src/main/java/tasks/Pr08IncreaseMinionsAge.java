package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Pr08IncreaseMinionsAge implements Executable {
    Scanner sc = new Scanner(System.in);

    Connection connection;

    public Pr08IncreaseMinionsAge(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() throws SQLException {
        System.out.printf("Paste the task's input on the next rows:%n");

        int[] ids = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < ids.length; i++) {
            updateMinionAgeAndName(ids[i]);
        }

        ResultSet resultSet = getAllMinions();
        print(resultSet);
    }

    private ResultSet getAllMinions() throws SQLException {
        String query = "SELECT name, age FROM minions;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    private void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private void updateMinionAgeAndName(int id) throws SQLException {
        String query = "UPDATE minions SET age = age + 1, name = CONCAT(LOWER(LEFT(name,1)),SUBSTRING(name, 2)) WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
