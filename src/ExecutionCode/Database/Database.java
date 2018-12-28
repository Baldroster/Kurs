package ExecutionCode.Database;


import org.h2.jdbc.JdbcSQLException;

import java.sql.*;


public class Database {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;
    public void getConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");

    }

    public void Initialize () throws SQLException {

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query

            try {
                String query = "SELECT * FROM USERS";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                System.out.println(stmt.toString());
                stmt = conn.createStatement();
            } catch (JdbcSQLException e) {

                System.out.println("Creating table in given database...");
                stmt = conn.createStatement();
                String sql = "CREATE TABLE  USERS" +
                        "(id_user INTEGER auto_increment, " +
                        " LOG VARCHAR(255), " +
                        " PASS VARCHAR(255), " +
                        " PRIMARY KEY ( id_user ))";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE    ROOM" +
                        "(id_room INTEGER not NULL, " +
                        " price INTEGER(10), " +
                        " commentary_room VARCHAR(255), " +
                        " PRIMARY KEY ( id_room ))";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE   GUEST " +
                        "(id_guest INTEGER auto_increment, " +
                        " id_room INTEGER not NULL, " +
                        " first VARCHAR(255), " +
                        " last VARCHAR(255), " +
                        " father VARCHAR(255), " +
                        " age INTEGER, " +
                        " phone VARCHAR(10), " +
                        " passport VARCHAR(10), " +
                        " commentary_guest VARCHAR(255), " +
                        " PRIMARY KEY ( id_guest ))";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE   WORKER" +
                        "(id_worker INTEGER auto_increment, " +
                        " id_room INTEGER not NULL, " +
                        " first VARCHAR(255), " +
                        " last VARCHAR(255), " +
                        " father VARCHAR(255), " +
                        " age INTEGER, " +
                        " phone_guest VARCHAR(10), " +
                        " passport VARCHAR(10), " +
                        " salary VARCHAR(255), " +
                        " PRIMARY KEY ( id_worker ))";
                stmt.executeUpdate(sql);

                sql = "INSERT into ROOM values (0, '101', 'Test');";
                stmt.executeUpdate(sql);

                sql = "INSERT into GUEST values (0, 0, 'Test' , 'Test' , 'Test' , 'Test' , 0 , 'Test' , 'Test' , 'Test');";
                stmt.executeUpdate(sql);

                sql = "INSERT into WORKER values (0, 0, 'Test' , 'Test' , 'Test' , 'Test' , 0 , 'Test' , 'Test' , 'Test');";
                stmt.executeUpdate(sql);

                sql = "INSERT into USERS values (1, 'log', 'pass');";
                stmt.executeUpdate(sql);


                System.out.println("Created table in given database...");
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }
    public void cleanup() throws SQLException {
        // STEP 4: Clean-up environment
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException se2) {
        } // nothing we can do
        stmt.close();
        conn.close();

        System.out.println("Goodbye!");
    }
}
