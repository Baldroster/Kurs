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
        database.getConnection();
        String sql = "SELECT log, pass FROM USERS WHERE LOG = '"+query.getLog()+"' AND PASS = '"+query.getPass()+"';";

       try {
            database.stmt=database.conn.createStatement();
            ResultSet rs = database.stmt.executeQuery(sql);
           if((query.getLog().equals(rs.getString("LOG")) && (query.getPass().equals(rs.getString("PASS"))))) {
               return true;
           }
           else{
               return false;
           }
       }
       catch (JdbcSQLException e){
           return false;
        }

    }
}
