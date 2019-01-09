package ExecutionCode.Database;

import java.sql.SQLException;

public class DeterminateBase {
    static Database database = new Database();
    public static void determinateDatabase() throws SQLException {
        database.Initialize();
        String sql = "DROP TABLE Worker;";
        database.stmt.executeUpdate(sql);
        sql = "DROP TABLE Guest;";
        database.stmt.executeUpdate(sql);
        sql = "DROP TABLE Users;";
        database.stmt.executeUpdate(sql);
        sql = "DROP TABLE Room;";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }
}
