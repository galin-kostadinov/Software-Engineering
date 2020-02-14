package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String DATABASE_NAME = "minions_db";

    public static void main(String[] args) throws SQLException {

        //Please, Change user and password if your properties are different.
        String user = "root";
        String password = "";

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection(CONNECTION_STRING + DATABASE_NAME, properties);

        Engine engine = new Engine(connection);
        engine.run();
    }
}
