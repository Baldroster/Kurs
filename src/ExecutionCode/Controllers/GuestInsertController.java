package ExecutionCode.Controllers;

import ExecutionCode.BaseObjects.Guest;
import ExecutionCode.Database.SqlQuery;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GuestInsertController {

    private Guest guest = new Guest();

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField fieldIdRoom;

    @FXML
    private TextField fieldId;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSoname;

    @FXML
    private TextField fieldFather;

    @FXML
    private TextField fieldAge;

    @FXML
    private TextField fieldPhone;

    @FXML
    private TextField fieldPassport;

    @FXML
    private TextField fieldCommentary;

    @FXML
    private Label errorLabel;

    @FXML
    private void clickBackButton() throws IOException {
        returnToMainWindow();
    }

    @FXML
    private void clickSaveButton() throws SQLException, IOException {
        receiveValueFromFields();
        if(guest.checkValidationInsert()){
            if (SqlQuery.checkNotDuplicateGuest(guest)){
                SqlQuery.setGuest(guest);
                returnToMainWindow();
            }
            else{
                clearTextAreas();
                errorLabel.setText("Данный гость уже существует");
                errorLabel.setVisible(true);
            }
        }
        else {
            clearTextAreas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    private void clearTextAreas(){
        fieldIdRoom.setText("");
        fieldName.setText("");
        fieldSoname.setText("");
        fieldFather.setText("");
        fieldAge.setText("");
        fieldPhone.setText("");
        fieldPassport.setText("");
        fieldCommentary.setText("");
    }
    private  void returnToMainWindow() throws IOException {
        Stage stage = (Stage) fieldIdRoom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/MainForm.fxml"));
        stage = new Stage();
        stage.setTitle("Главное Окно");
        stage.setScene(new Scene(root, 380, 400));
        stage.show();
    }

    private void receiveValueFromFields(){
        guest.setIdRoom(fieldIdRoom.getCharacters().toString());
        guest.setName(fieldName.getCharacters().toString());
        guest.setSoname(fieldSoname.getCharacters().toString());
        guest.setFather(fieldFather.getCharacters().toString());
        guest.setAge(fieldAge.getCharacters().toString());
        guest.setPhone(fieldPhone.getCharacters().toString());
        guest.setPassport(fieldPassport.getCharacters().toString());
        guest.setCommentary(fieldCommentary.getCharacters().toString());
    }
}
