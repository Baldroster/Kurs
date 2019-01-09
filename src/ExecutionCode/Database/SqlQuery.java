package ExecutionCode.Database;

import ExecutionCode.BaseObjects.Guest;
import ExecutionCode.BaseObjects.Room;
import ExecutionCode.BaseObjects.User;
import ExecutionCode.BaseObjects.Worker;
import org.h2.jdbc.JdbcSQLException;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class SqlQuery {
    static Database database = new Database();
    public static boolean getUsers(User query) throws SQLException {
        database.Initialize();
        String sql = "SELECT log, pass FROM USERS WHERE LOG = '"+query.getLog()+"' AND PASS = '"+query.getPass()+"';";

       try {

            ResultSet rs = database.stmt.executeQuery(sql);
           rs.next();
           System.out.println(rs.getString("LOG"));
           System.out.println(rs.getString("PASS"));
           System.out.println(query.getLog());
           System.out.println(query.getPass());

           if((query.getLog().equals(rs.getString("LOG")) && (query.getPass().equals(rs.getString("PASS"))))) {
               return true;
           }
           else{
               return false;
           }
       }
       catch (JdbcSQLException e){
           e.printStackTrace();
           return false;
        }
        finally {
           database.cleanup();
       }
    }

    public static void setRoom(Room room) throws SQLException {
        database.Initialize();
        String sql = "INSERT INTO ROOM VALUES("+room.getId()+", '"+room.getPrice()+"', '"+room.getCommentary()+"')";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }

    public static void setGuest(Guest guest) throws SQLException {
        database.Initialize();
        String sql = "INSERT INTO GUEST VALUES( default, "+guest.getIdRoom()+", '"+guest.getName()+"', '"+guest.getSoname()+"', '"+guest.getFather()+"', '"+guest.getAge()+"', '"+guest.getPhone()+"', '"+guest.getPassport()+"', '"+guest.getCommentary()+"')";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }

    public static void setWorker (Worker worker) throws SQLException {
        database.Initialize();
        String sql = "INSERT INTO WORKER VALUES( default, "+worker.getIdRoom()+", '"+worker.getName()+"', '"+worker.getSoname()+"', '"+worker.getFather()+"', '"+worker.getAge()+"', '"+worker.getPhone()+"', '"+worker.getPassport()+"', '"+worker.getSalary()+"')";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }

    public static boolean checkNotDuplicateRoom(Room room) throws SQLException {

        String sql = "SELECT id_room FROM ROOM";
            database.Initialize();
            ResultSet rs = database.stmt.executeQuery(sql);
            while(rs.next()){
                if(room.getId().equals(rs.getString("id_room"))){
                 return false;
                }
            }
            return true;

    }
    public static boolean checkNotDuplicateGuest(Guest guest) throws SQLException {

        String sql = "SELECT * FROM GUEST";
        database.Initialize();
        ResultSet rs = database.stmt.executeQuery(sql);
        while(rs.next()){
            if(guest.getPassport().equals(rs.getString("passport"))){
                return false;
            }
        }
        return true;

    }

     public static boolean checkNotDuplicateWorker(Worker worker) throws SQLException {

         String sql = "SELECT * FROM WORKER";
         database.Initialize();
         ResultSet rs = database.stmt.executeQuery(sql);
         while(rs.next()){
             if(worker.getPassport().equals(rs.getString("passport"))){
                 return false;
             }
         }
         return true;

     }

    public static String generateSqlSearchRoom(Room room) {
        String sql = "SELECT * FROM ROOM WHERE";
        if (!room.getId().equals("")) {
            sql += " id_room = '" + room.getId()+"'";
        } else {
            sql += " 1 = 1";
        }
        if (!room.getPrice().equals("")) {
            sql += " AND price = '" + room.getPrice()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!room.getCommentary().equals("")) {
            sql += " AND commentary_room = '" + room.getCommentary() + "';";
        } else {
            sql += " AND 1 = 1;";
        }
        return sql;
    }

    public static String generateSqlSearchGuest(Guest guest) {
        String sql = "SELECT * FROM Guest WHERE";
        if (!guest.getId().equals("")) {
            sql += " id_guest = '" + guest.getId()+"'";
        } else {
            sql += " 1 = 1";
        }
        if (!guest.getIdRoom().equals("")) {
            sql += " AND id_room = '" + guest.getIdRoom()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getName().equals("")) {
            sql += " AND first = '" + guest.getName()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getSoname().equals("")) {
            sql += " AND last = '" + guest.getSoname()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getFather().equals("")) {
            sql += " AND father = '" + guest.getFather()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getAge().equals("")) {
            sql += " AND age = '" + guest.getAge()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getPhone().equals("")) {
            sql += " AND phone = '" + guest.getPhone()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getPassport().equals("")) {
            sql += " AND price = '" + guest.getPassport()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!guest.getCommentary().equals("")) {
            sql += " AND commentary_guest = '" + guest.getCommentary() + "';";
        } else {
            sql += " AND 1 = 1;";
        }
        return sql;
    }

    public static String generateSqlSearchWorker(Worker worker) {
        String sql = "SELECT * FROM WORKER WHERE";
        if (!worker.getId().equals("")) {
            sql += " id_worker = '" + worker.getId()+"'";
        } else {
            sql += " 1 = 1";
        }
        if (!worker.getIdRoom().equals("")) {
            sql += " AND id_room = '" + worker.getIdRoom()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getName().equals("")) {
            sql += " AND first = '" + worker.getName()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getSoname().equals("")) {
            sql += " AND last = '" + worker.getSoname()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getFather().equals("")) {
            sql += " AND father = '" + worker.getFather()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getAge().equals("")) {
            sql += " AND age = '" + worker.getAge()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getPhone().equals("")) {
            sql += " AND phone_guest = '" + worker.getPhone()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getPassport().equals("")) {
            sql += " AND price = '" + worker.getPassport()+"'";
        } else {
            sql += " AND 1 = 1";
        }
        if (!worker.getSalary().equals("")) {
            sql += " AND salary = '" + worker.getSalary() + "';";
        } else {
            sql += " AND 1 = 1;";
        }
        return sql;
    }

    public static List<Room> getRoomQuery(String sql) throws SQLException {
        List<Room> results = new ArrayList();
        database.Initialize();
        ResultSet rs = database.stmt.executeQuery(sql);
        while (rs.next()){
            Room room = new Room();
            room.setId(rs.getString("id_room"));
            room.setPrice(rs.getString("price"));
            room.setCommentary(rs.getString("commentary_room"));
            System.out.println(room.toString());
            results.add(room);
        }
        return results;
    }

    public static List<Guest> getGuestQuery(String sql) throws SQLException {
        List<Guest> results = new ArrayList();
        database.Initialize();
        ResultSet rs = database.stmt.executeQuery(sql);
        while (rs.next()){
            Guest guest = new Guest();
            guest.setId(rs.getString("id_guest"));
            guest.setIdRoom(rs.getString("id_room"));
            guest.setName(rs.getString("first"));
            guest.setSoname(rs.getString("last"));
            guest.setFather(rs.getString("father"));
            guest.setAge(rs.getString("age"));
            guest.setPhone(rs.getString("phone"));
            guest.setPassport(rs.getString("passport"));
            guest.setCommentary(rs.getString("commentary_guest"));
            System.out.println(guest.toString());
            results.add(guest);
        }
        return results;
    }

    public static List<Worker> getWorkerQuery(String sql) throws SQLException {
        List<Worker> results = new ArrayList();
        database.Initialize();
        ResultSet rs = database.stmt.executeQuery(sql);
        while (rs.next()){
            Worker worker = new Worker();
            worker.setId(rs.getString("id_worker"));
            worker.setIdRoom(rs.getString("id_room"));
            worker.setName(rs.getString("first"));
            worker.setSoname(rs.getString("last"));
            worker.setFather(rs.getString("father"));
            worker.setAge(rs.getString("age"));
            worker.setPhone(rs.getString("phone_guest"));
            worker.setPassport(rs.getString("passport"));
            worker.setSalary(rs.getString("salary"));
            System.out.println(worker.toString());
            results.add(worker);
        }
        return results;
    }

    public static boolean checkStatementDoesExist(String sql) {
        try {
            database.Initialize();
            ResultSet rs = database.stmt.executeQuery(sql);
            if(!rs.next()){
                System.out.println("size");
                return false;
            }
        } catch (JdbcSQLException e) {
            e.printStackTrace();
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static  void deleteRoom(Room room) throws SQLException {
        database.Initialize();
        String sql = "DELETE FROM ROOM WHERE id_room = "+room.getId()+";";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }

    public static  void deleteGuest(Guest guest) throws SQLException {
        database.Initialize();
        String sql = "DELETE FROM Guest WHERE id_guest = "+guest.getId()+";";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }

    public static  void deleteWorker(Worker worker) throws SQLException {
        database.Initialize();
        String sql = "DELETE FROM Worker WHERE id_worker = "+worker.getId()+";";
        database.stmt.executeUpdate(sql);
        database.cleanup();
    }

}
