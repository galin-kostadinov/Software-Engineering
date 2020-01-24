package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pr07PrintAllMinionNames implements Executable {
    Connection connection;
    List<String> minionNames;

    public Pr07PrintAllMinionNames(Connection connection) {
        this.connection = connection;
        minionNames = new ArrayList<>();
    }

    @Override
    public void execute() throws SQLException {
        retrieveMinionsFromDatabaseIntoList();
        print(minionNames);
    }

    private void print(List<String> minionNames) {
        int size = minionNames.size();

        for (int i = 0; i < size / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(size - i - 1));
        }

        if (size % 2 != 0) {
            System.out.println(minionNames.get(size / 2));
        }
    }

    private void retrieveMinionsFromDatabaseIntoList() throws SQLException {
        String query = "SELECT name FROM minions;";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            minionNames.add(resultSet.getString(1));
        }
    }
}
