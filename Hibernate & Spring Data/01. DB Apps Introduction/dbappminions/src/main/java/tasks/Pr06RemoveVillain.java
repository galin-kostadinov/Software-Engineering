package tasks;

import java.sql.*;
import java.util.Scanner;

public class Pr06RemoveVillain implements Executable {
    Scanner sc = new Scanner(System.in);

    Connection connection;

    public Pr06RemoveVillain(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() throws SQLException {
        System.out.printf("Enter Villain id:%n");
        int id = Integer.parseInt(sc.nextLine());

        String villainName = getsVillainName(id);

        if (villainName.isEmpty()) {
            System.out.println("No such villain was found");
            return;
        }

        int minionCount = getMinionCount(id);

        callUspRemoveVillain(id);

        if (getsVillainName(id).isEmpty()) {
            System.out.printf("%s was deleted%n", villainName);
        }

        if (minionCount == 0 || getMinionCount(id) == 0) {
            System.out.printf("%d minions released", minionCount);
        }
    }

    private boolean callUspRemoveVillain(int id) throws SQLException {
        String query = "CALL usp_remove_villain(?);";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setLong(1, id);
        return callableStatement.execute();
    }


    private int getMinionCount(int id) throws SQLException {
        String query = "SELECT COUNT(minion_id) FROM minions_villains WHERE villain_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        return 0;
    }

    private String getsVillainName(int id) throws SQLException {
        String query = "SELECT name FROM villains WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("name");
        }

        return "";
    }
}
