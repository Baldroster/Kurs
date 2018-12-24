package ExecutionCode.Database;

import ExecutionCode.BaseObjects.User;
import org.h2.jdbc.JdbcSQLException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class SqlQuery {
    static Database database = new Database();
    public static boolean getUsers(User query) throws SQLException {
        database.Initialize();
        String sql = "SELECT log, pass FROM USERS WHERE log="+query.getLog()+"pass="+query.getPass()+";";

        try {
            database.stmt=database.conn.createStatement();
            ResultSet rs = database.stmt.executeQuery(sql);
        }
        catch (JdbcSQLException e){
            return false;
        }
        return true;
    }
}
