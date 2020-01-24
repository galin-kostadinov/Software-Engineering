package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pr04AddMinion implements Executable {
    Scanner sc = new Scanner(System.in);

    Connection connection;

    public Pr04AddMinion(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void execute() throws SQLException {
        System.out.printf("Paste the task's input on the next rows:%n");

        String[] tokensMinionProp = sc.nextLine().split("\\s+");
        String minionName = tokensMinionProp[1];
        int minionAge = Integer.parseInt(tokensMinionProp[2]);
        String minionTown = tokensMinionProp[3];

        String[] tokensVillainProp = sc.nextLine().split("\\s+");
        String villainName = tokensVillainProp[1];

        String tableMinions = "minions";
        long idTown = getEntityIdByName(tableMinions, minionTown);

        if (idTown < 0) {
            addTown(minionTown);
            idTown = getEntityIdByName(tableMinions, minionTown);
        }

        String tableVillains = "villains";
        long villainId = getEntityIdByName(tableVillains, villainName);

        if (villainId < 0) {
            addVillains(villainName);
            villainId = getEntityIdByName(tableVillains, villainName);
        }

        addMinionInMinions(minionName, minionAge, idTown);
        long minionId = getMinionId(minionName, minionAge, idTown);

        setMinionLikeServant(minionId, villainId);

        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
    }

    private void setMinionLikeServant(long minionId, long villainId) throws SQLException {
        String query = "INSERT INTO minions_villains (`minion_id`, `villain_id`) VALUE (?, ?);";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setLong(1, minionId);
        preparedStatement.setLong(2, villainId);
        preparedStatement.execute();
    }

    private long getMinionId(String minionName, int minionAge, long idTown) throws SQLException {
        String query = "SELECT m.id FROM `minions` AS m WHERE m.name = ? AND m.age = ? AND m.town_id = ? ORDER BY m.id DESC LIMIT 1;";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setLong(3, idTown);

        ResultSet resultMinionId = preparedStatement.executeQuery();
        resultMinionId.next();

        return resultMinionId.getLong(1);
    }

    private void addMinionInMinions(String minionName, int minionAge, long idTown) throws SQLException {
        String query = "INSERT INTO minions (`name`, `age`, town_id) VALUE (?, ?, ?);";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setLong(3, idTown);
        preparedStatement.execute();
    }

    private void addVillains(String villainName) throws SQLException {
        String query = "INSERT INTO villains (`name`, `evilness_factor`) VALUE (?, 'evil');";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setString(1, villainName);
        preparedStatement.execute();

        System.out.printf("Villain %s was added to the database.%n", villainName);
    }

    private void addTown(String minionTown) throws SQLException {
        String query = "INSERT INTO towns (`name`) VALUE (?);";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setString(1, minionTown);
        preparedStatement.execute();

        System.out.printf("Town %s was added to the database.%n", minionTown);
    }

    private long getEntityIdByName(String tableName, String entityName) throws SQLException {
        String query = "SELECT id FROM " + tableName + " WHERE  name = ?;";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, entityName);

        ResultSet resultSet = preparedStatement.executeQuery();

        long id = -1;

        if (resultSet.next()) {
            id = resultSet.getLong(1);
        }

        return id;
    }
}
