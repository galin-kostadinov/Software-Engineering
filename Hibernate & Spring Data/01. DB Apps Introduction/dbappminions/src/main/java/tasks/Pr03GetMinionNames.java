package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pr03GetMinionNames implements Executable {
    Scanner sc = new Scanner(System.in);
    Connection connection;

    public Pr03GetMinionNames(Connection connection) {
        this.connection = connection;
    }

    private void getMinionNames() throws SQLException {
        String villainNameById =
                "SELECT v.name FROM villains as v WHERE v.id = ?;";

        String allMinionByVillainId =
                "SELECT m.name, m.age FROM minions as m JOIN minions_villains as mv ON m.id = mv.minion_id WHERE mv.villain_id = ?;";

        PreparedStatement prsmVillainName =
                this.connection.prepareStatement(villainNameById);

        long villainId = Long.parseLong(sc.next());
        prsmVillainName.setLong(1, villainId);
        ResultSet resultVillainName = prsmVillainName.executeQuery();

        if (resultVillainName.next()) {
            System.out.println(String.format("Villain: %s", resultVillainName.getString("name")));
        } else {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        PreparedStatement prsmMinions =
                this.connection.prepareStatement(allMinionByVillainId);

        prsmMinions.setLong(1, villainId);
        ResultSet resultSetMinions = prsmMinions.executeQuery();

        int index = 1;

        while (resultSetMinions.next()) {
            System.out.println(
                    String.format("%d. %s %d",
                            index++,
                            resultSetMinions.getString(1),
                            resultSetMinions.getInt(2)));
        }
    }

    @Override
    public void execute() throws SQLException {
        System.out.printf("Paste task input on the next rows:%n");
        this.getMinionNames();
    }
}
