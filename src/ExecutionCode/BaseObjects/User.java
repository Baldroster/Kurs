package ExecutionCode.BaseObjects;

public class User {
    private String id ;
    private String log;
    private String pass;


public User(){
    id ="";
    log ="";
    pass ="";
}
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPass() {
        return pass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }


}
