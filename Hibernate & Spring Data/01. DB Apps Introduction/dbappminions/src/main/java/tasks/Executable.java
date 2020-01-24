package tasks;

import java.sql.SQLException;

public interface Executable {
    void execute() throws SQLException;
}
