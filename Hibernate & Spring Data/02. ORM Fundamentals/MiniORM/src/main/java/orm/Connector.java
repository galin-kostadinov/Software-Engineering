package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static String CONNECTRION_STRING = "jdbc:mysql://localhost:3306/company_db";

    private static Connection connection;

    public static void createConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);

        connection = DriverManager.getConnection(CONNECTRION_STRING, props);
    }

    public static void createConnection(String username,
                                     String password,
                                     String dbName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + dbName, properties);
    }

    public static Connection getConnection() {
        return connection;
    }
}
