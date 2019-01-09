package ExecutionCode.BaseObjects;

import ExecutionCode.Database.CheckValidation;

public class Room {
    private String id;
    private String price;
    private String commentary;

    public Room(){
        id = "";
        price = "";
        commentary = "";
    }

    public void clearValues(){
        id = "";
        price = "";
        commentary = "";
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean checkValidationInsert(){
        if(checkValidation()&&CheckValidation.checkNotNull(id)&&CheckValidation.checkNotNull(price)){
            return true;
        }
        else {
            clearValues();
            return false;
        }
    }

    public boolean checkValidation(){
        if(CheckValidation.checkInt(id)&&CheckValidation.checkInt(price)){
            return true;
        }
        else {
           clearValues();
            return false;
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", commentary='" + commentary + '\'' +
                '}';
    }
}
