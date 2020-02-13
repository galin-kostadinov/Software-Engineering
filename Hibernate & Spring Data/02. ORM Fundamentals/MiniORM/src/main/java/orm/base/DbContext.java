package orm.base;

import java.sql.SQLException;

public interface DbContext<E> {
    //insert + update
    boolean persist(E entity) throws IllegalAccessException, SQLException;

    Iterable<E> find() throws SQLException, IllegalAccessException, InstantiationException;

    Iterable<E> find(String where) throws SQLException, IllegalAccessException, InstantiationException;

    E findFirst() throws IllegalAccessException, SQLException, InstantiationException;

    E findFirst(String where) throws IllegalAccessException, SQLException, InstantiationException;

    E findById(long id) throws IllegalAccessException, SQLException, InstantiationException;

    boolean delete(String where) throws SQLException;
}
