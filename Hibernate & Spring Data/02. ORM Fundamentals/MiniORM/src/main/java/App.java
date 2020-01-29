import entities.User;
import orm.Connector;
import orm.EntityManager;
import orm.base.DbContext;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
        Connector.createConnection();
        Connection connection = Connector.getConnection();

        DbContext<User> userDbContext = getDbContext(connection, User.class);

        User user = userDbContext.findById(4);
        user.setLastName("IVANOV");
        userDbContext.persist(user);
    }

    private static <E> DbContext<E> getDbContext(Connection connection, Class<E> klass) throws SQLException {
        return new EntityManager<>(connection, klass);
    }
}
