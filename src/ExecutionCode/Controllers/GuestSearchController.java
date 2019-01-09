package ExecutionCode.Controllers;

import ExecutionCode.BaseObjects.Guest;
import ExecutionCode.BaseObjects.Room;
import ExecutionCode.BaseObjects.User;
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
import java.util.ArrayList;
import java.util.List;

public class GuestSearchController {
    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button searchButton;

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

    private Guest guest = new Guest();
    private List<Guest> searchedGuest = new ArrayList();
    private int index = 0;

     @FXML
     private void clickSearchButton() throws SQLException {
         receiveValueFromFields();
         if(guest.checkValidation()){
             if(SqlQuery.checkStatementDoesExist(SqlQuery.generateSqlSearchGuest(guest)))
             {
                 searchedGuest = SqlQuery.getGuestQuery(SqlQuery.generateSqlSearchGuest(guest));
                 fillTextareas();
                 convertWindowIntoSearchResults();
             }
             else {
                 clearTextAreas();
                 errorLabel.setText("Значений не найдено");
                 errorLabel.setVisible(true);
             }
         }
         else {
             clearTextAreas();
             errorLabel.setText("Введите верные значения");
             errorLabel.setVisible(true);
         }
     }

    @FXML
    private void clickNextButton(){
        index++;
        disableNavigateButtons();
        fillTextareas();
    }

    @FXML
    private void clickPreviousButton(){
        index--;
        disableNavigateButtons();
        fillTextareas();
    }

    @FXML
    private void clickSaveButton() throws IOException, SQLException {
        receiveValueFromFields();
        if(guest.checkValidationInsert()){

            receiveValueFromFields();
            SqlQuery.deleteGuest(guest);
            SqlQuery.setGuest(guest);
            returnToMainWindow();
        }
        else {
            fillTextareas();
            errorLabel.setText("Введите верные значения");
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private void clickDeleteButton() throws IOException, SQLException {
        receiveValueFromFields();
        SqlQuery.deleteGuest(guest);
        returnToMainWindow();
    }

    @FXML
    private void clickBackButton() throws IOException {
        returnToMainWindow();
    }

    private  void returnToMainWindow() throws IOException {
        Stage stage = (Stage) fieldId.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/Xmls/MainForm.fxml"));
        stage = new Stage();
        stage.setTitle("Главное Окно");
        stage.setScene(new Scene(root, 380, 400));
        stage.show();
    }

    private void clearTextAreas(){
        fieldId.setText("");
        fieldIdRoom.setText("");
        fieldName.setText("");
        fieldSoname.setText("");
        fieldFather.setText("");
        fieldAge.setText("");
        fieldPhone.setText("");
        fieldPassport.setText("");
        fieldCommentary.setText("");
    }

    private void convertWindowIntoSearchResults(){
        saveButton.setVisible(true);
        nextButton.setVisible(true);
        previousButton.setVisible(true);
        deleteButton.setVisible(true);
        searchButton.setVisible(false);
        disableNavigateButtons();
        fieldId.setDisable(true);
    }

    private void disableNavigateButtons(){
        if(searchedGuest.size()-1 == index)
        {
            nextButton.setDisable(true);
        }
        else{
            nextButton.setDisable(false);
        }
        if(index == 0){
            previousButton.setDisable(true);
        }
        else{
            previousButton.setDisable(false);
        }
    }

    private void fillTextareas(){
        fieldId.setText(searchedGuest.get(index).getId());
        fieldIdRoom.setText(searchedGuest.get(index).getIdRoom());
        fieldName.setText(searchedGuest.get(index).getName());
        fieldSoname.setText(searchedGuest.get(index).getSoname());
        fieldFather.setText(searchedGuest.get(index).getFather());
        fieldAge.setText(searchedGuest.get(index).getAge());
        fieldPhone.setText(searchedGuest.get(index).getPhone());
        fieldPassport.setText(searchedGuest.get(index).getPassport());
        fieldCommentary.setText(searchedGuest.get(index).getCommentary());
    }

    private void receiveValueFromFields(){
        guest.setId(fieldId.getCharacters().toString());
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

