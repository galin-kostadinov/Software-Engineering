package orm;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.PrimaryKey;
import orm.base.DbContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private static final String SELECT_QUERY_TEMPLATE = "SELECT * FROM {0}";
    private static final String SELECT_WHERE_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE {1}";
    private static final String SELECT_SINGLE_QUERY_TEMPLATE = "SELECT * FROM {0} LIMIT 1";
    private static final String SELECT_SINGLE_WHERE_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE {1} LIMIT 1";
    private static final String INSERT_QUERY_TEMPLATE = "INSERT INTO {0}({1}) VALUES({2})";
    private static final String UPDATE_QUERY_TEMPLATE = "UPDATE {0} SET {1} WHERE {2}={3}";

    private static final String SET_QUERY_TEMPLATE = "{0}={1}";
    private static final String WHERE_PRIMARY_KEY = " {0}={1} ";

    private final Connection connection;
    private final Class<E> klass;

    public EntityManager(Connection connection, Class<E> klass) throws SQLException {
        this.connection = connection;
        this.klass = klass;

        if (this.checksIfTableExists()) {
            this.updateTable();
        } else {
            this.createTable();
        }
    }

    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primaryKeyField = getPrimaryKeyField();
        primaryKeyField.setAccessible(true);
        long primaryKey = (long) primaryKeyField.get(entity);

        if (primaryKey > 0) {
            return update(entity);
        }

        return insert(entity);
    }

    private boolean insert(E entity) throws SQLException {
        List<String> columns = new ArrayList<>();
        List<Object> values = new ArrayList<>();

        getColumnFields()
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        String columnName = field.getAnnotation(Column.class)
                                .name();
                        Object value = field.get(entity);
                        columns.add(columnName);
                        values.add(value);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        String columnsNames = String.join(", ", columns);
        String columnValues = values
                .stream()
                .map(value -> {
                    if (value instanceof String) {
                        return "\'" + value + "\'";
                    }

                    return value;
                })
                .map(o -> {
                    if (o == null) {
                        return "NULL";
                    } else {
                        return o.toString();
                    }
                })
                .collect(Collectors.joining(", "));

        String queryString = MessageFormat.format(
                INSERT_QUERY_TEMPLATE,
                getTableName(),
                columnsNames,
                columnValues
        );

        return connection.prepareStatement(queryString).execute();
    }

    private boolean update(E entity) throws SQLException, IllegalAccessException {
        List<String> updateQueries = getColumnFields()
                .stream()
                .map(field -> {
                    field.setAccessible(true);
                    try {
                        String columnName = field.getAnnotation(Column.class).name();
                        Object value = field.get(entity);

                        if (value instanceof String) {
                            value = "\'" + value + "\'";
                        }

                        return MessageFormat.format(SET_QUERY_TEMPLATE, columnName, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    return null;
                })
                .collect(Collectors.toList());


        String updateQueriesString = String.join(", ", updateQueries);

        Field primaryKeyField = getPrimaryKeyField();
        primaryKeyField.setAccessible(true);
        String primaryKeyName = primaryKeyField.getAnnotation(PrimaryKey.class).name();
        long primaryKeyValue = (long) primaryKeyField.get(entity);

        String queryString = MessageFormat.format(UPDATE_QUERY_TEMPLATE,
                getTableName(),
                updateQueriesString,
                primaryKeyName,
                primaryKeyValue);

        return connection.prepareStatement(queryString).execute();
    }

    public Iterable<E> find() throws SQLException, IllegalAccessException, InstantiationException {
        String queryString = MessageFormat.format(SELECT_QUERY_TEMPLATE, getTableName());

        PreparedStatement query = connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        return toList(resultSet);
    }

    @Override
    public Iterable<E> find(String where) throws SQLException, IllegalAccessException, InstantiationException {
        String queryTemplate = where == null ? SELECT_QUERY_TEMPLATE : SELECT_WHERE_QUERY_TEMPLATE;

        return find(queryTemplate, where);
    }

    private Iterable<E> find(String template, String where) throws SQLException, IllegalAccessException, InstantiationException {
        String queryString = MessageFormat.format(template, getTableName(), where);

        PreparedStatement query = connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        return toList(resultSet);
    }

    @Override
    public E findFirst() throws IllegalAccessException, SQLException, InstantiationException {
        return findFirst(null);
    }

    @Override
    public E findFirst(String where) throws IllegalAccessException, SQLException, InstantiationException {
        String queryTemplate = where == null ? SELECT_SINGLE_QUERY_TEMPLATE : SELECT_SINGLE_WHERE_QUERY_TEMPLATE;

        return find(queryTemplate, where).iterator().next();
    }

    @Override
    public E findById(long id) throws IllegalAccessException, SQLException, InstantiationException {
        String primaryKeyName = getPrimaryKeyField().getAnnotation(PrimaryKey.class).name();
        String whereString = MessageFormat.format(WHERE_PRIMARY_KEY, primaryKeyName, id);

        return findFirst(whereString);
    }

    private String getTableName() {
        Annotation annotation = Arrays.stream(klass.getAnnotations())
                .filter(a -> a.annotationType() == Entity.class)
                .findFirst()
                .orElse(null);

        if (annotation == null) {
            return klass.getSimpleName().toLowerCase() + "s";
        }

        return klass.getAnnotation(Entity.class).name();
    }

    private Iterable<E> toList(ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException {
        List<E> result = new ArrayList<>();

        while (resultSet.next()) {
            E entity = this.createEntity(resultSet);
            result.add(entity);
        }

        return result;
    }

    private E createEntity(ResultSet resultSet) throws IllegalAccessException, InstantiationException {
        E entity = klass.newInstance();

        Field primaryKeyField = getPrimaryKeyField();

        primaryKeyField.setAccessible(true);

        try {
            String columnName = primaryKeyField.getAnnotation(PrimaryKey.class).name();
            if (primaryKeyField.getType() == Integer.class || primaryKeyField.getType() == int.class) {
                int value = resultSet.getInt(columnName);
                primaryKeyField.set(entity, value);
            } else if (primaryKeyField.getType() == Long.class || primaryKeyField.getType() == long.class) {
                long value = resultSet.getLong(columnName);
                primaryKeyField.set(entity, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Field> columnFields = getColumnFields();

        columnFields.forEach(field -> {
            String columnName = field.getAnnotation(Column.class).name();
            try {
                field.setAccessible(true);
                if (field.getType() == Integer.class || field.getType() == int.class) {
                    long value = resultSet.getInt(columnName);
                    field.set(entity, value);
                } else if (field.getType() == Long.class || field.getType() == long.class) {
                    long value = resultSet.getLong(columnName);
                    field.set(entity, value);
                } else if (field.getType() == String.class) {
                    String value = resultSet.getString(columnName);
                    field.set(entity, value);
                } else if (field.getType() == Date.class) {
                    Date value = resultSet.getDate(columnName);
                    field.set(entity, value);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return entity;
    }

    private List<Field> getColumnFields() {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private Field getPrimaryKeyField() {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Class " + klass.getSimpleName() + "does not have primary key annotation"));
    }

    private boolean checksIfTableExists() throws SQLException {
        String query = String
                .format(
                        "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '%s'",
                        this.getTableName()
                );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    private void updateTable() throws SQLException {
        List<String> entityColumnsNames = this.getColumnFields()
                .stream()
                .map(field -> {
                    return field.getDeclaredAnnotation(Column.class).name();
                })
                .collect(Collectors.toList());

        entityColumnsNames.add(this.getPrimaryKeyField().getDeclaredAnnotation(PrimaryKey.class).name());

        List<String> databaseTableColumnsNames = this.getDatabaseTableColumnsNames();

        List<String> newColumnsNames = entityColumnsNames
                .stream()
                .filter(columnName -> !databaseTableColumnsNames.contains(columnName))
                .collect(Collectors.toList());

        List<Field> newFields = this.getColumnFields()
                .stream()
                .filter(field -> {
                    return newColumnsNames.contains(field.getDeclaredAnnotation(Column.class).name());
                })
                .collect(Collectors.toList());

        List<String> columnsDefinitions = new ArrayList<>();

        newFields.stream().forEach(field -> {
            String columnDefinition = String
                    .format(
                            "ADD COLUMN %s %s",
                            field.getDeclaredAnnotation(Column.class).name(),
                            this.getColumnTypeString(field)
                    );

            columnsDefinitions.add(columnDefinition);
        });

        String queryBody = String.join(", ", columnsDefinitions);

        String query = String
                .format(
                        "ALTER TABLE %s %s",
                        this.getTableName(),
                        queryBody
                );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private String getColumnTypeString(Field field) {
        if (field.getType() == long.class || field.getType() == Long.class || field.getType() == int.class) {
            return "INT";
        } else if (field.getType() == String.class) {
            return "VARCHAR(255)";
        }

        return null;
    }

    private List<String> getDatabaseTableColumnsNames() throws SQLException {
        String query = String
                .format(
                        "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '%s'",
                        this.getTableName()
                );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> columnsNames = new ArrayList<>();

        while (resultSet.next()) {
            columnsNames.add(resultSet.getString(1));
        }

        return columnsNames;
    }

    private void createTable() throws SQLException {
        Field primaryKeyField = this.getPrimaryKeyField();
        String primaryKeyColumnName = primaryKeyField.getDeclaredAnnotation(PrimaryKey.class).name();
        String primaryKeyColumnType = this.getColumnTypeString(primaryKeyField);

        String primaryKeyColumnDefinition = String
                .format(
                        "%s %s PRIMARY KEY AUTO_INCREMENT",
                        primaryKeyColumnName,
                        primaryKeyColumnType
                );

        List<Field> columnsFields = this.getColumnFields();

        List<String> columnsParams = new ArrayList<>();

        columnsFields
                .stream()
                .forEach(field -> {
                    String columnName = field.getDeclaredAnnotation(Column.class).name();
                    String columnType = this.getColumnTypeString(field);

                    String columnDefinition = String
                            .format(
                                    "%s %s",
                                    columnName,
                                    columnType
                            );

                    columnsParams.add(columnDefinition);
                });

        String createStatementBody = String
                .format(
                        "%s, %s",
                        primaryKeyColumnDefinition,
                        columnsParams.stream().collect(Collectors.joining(", "))
                );

        String query = String
                .format(
                        "CREATE TABLE %s(%s)",
                        this.getTableName(),
                        createStatementBody
                );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    @Override
    public boolean delete(String where) throws SQLException {
        String query = String.format(
                "DELETE FROM %s WHERE %s",
                this.getTableName(),
                where
        );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        return preparedStatement.execute();
    }
}
