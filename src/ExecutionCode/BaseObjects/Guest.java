package ExecutionCode.BaseObjects;

import ExecutionCode.Database.CheckValidation;

public class Guest {
    private String id;
    private String idRoom;
    private String name;
    private String soname;
    private String father;
    private String age;
    private String phone;
    private String passport;
    private String commentary;

    public Guest() {
        this.id = "";
        this.idRoom = "";
        this.name = "";
        this.soname = "";
        this.father = "";
        this.age = "";
        this.phone = "";
        this.passport = "";
        this.commentary = "";
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id='" + id + '\'' +
                ", idRoom='" + idRoom + '\'' +
                ", name='" + name + '\'' +
                ", soname='" + soname + '\'' +
                ", father='" + father + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", passport='" + passport + '\'' +
                ", commentary='" + commentary + '\'' +
                '}';
    }
    private void clearValues() {
        this.id = "";
        this.idRoom = "";
        this.name = "";
        this.soname = "";
        this.father = "";
        this.age = "";
        this.phone = "";
        this.passport = "";
        this.commentary = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public boolean checkValidationInsert(){
        if(checkValidation()&& CheckValidation.checkNotNull(name)&&CheckValidation.checkNotNull(soname)&&CheckValidation.checkNotNull(father)&&CheckValidation.checkNotNull(age)&&CheckValidation.checkNotNull(phone)&&CheckValidation.checkNotNull(passport)){
            return true;
        }
        else {
            clearValues();
            return false;
        }
    }

    public boolean checkValidation(){
        if(CheckValidation.checkInt(age)&&CheckValidation.checkInt(phone)&&CheckValidation.checkInt(passport)&&CheckValidation.checkInt(id)&&CheckValidation.checkInt(idRoom)&&CheckValidation.checkLength(age,2)&&CheckValidation.checkLength(phone,10)&&CheckValidation.checkLength(passport,10)&&CheckValidation.checkRoomId(idRoom)){
            return true;
        }
        else {
            clearValues();
            return false;
        }
    }
}
