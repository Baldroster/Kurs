package ExecutionCode.Database;

public class CheckValidation {
    public static boolean checkInt(String value){
        if (value.equals("")){
            return true;
        }
        try {
            int i = 0;
            while(i<value.length()) {
                int temprInt = (int) value.charAt(i);
                i++;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("int");
        return false;
        }
        return true;
    }

    public static boolean checkLength(String value, int length){
        if (value.equals("")){
            return true;
        }
        if (value.length()== length){
            return true;
        }
        else{
            System.out.println("length");
            return false;
        }
    }

    public static boolean checkNotNull(String value){
        if (value.equals("")){
            System.out.println("null");
            return false;
        }
        return true;
    }

    public static boolean checkRoomId(String value){
        if (value.equals("")){
            return true;
        }
        String sql = "SELECT * FROM ROOM WHERE id_room ='"+value+"';";
        if(value.equals("")){
            return true;
        }
        if(SqlQuery.checkStatementDoesExist(sql)){
            return true;
        }
        else{
            System.out.println("room");
            return false;
        }
    }
}
